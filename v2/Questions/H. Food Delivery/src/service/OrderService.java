package service;

import exception.IllegalArguementException;
import exception.NotFoundException;
import exception.OrderNotFulfillableException;
import model.*;
import repository.OrderRepository;
import repository.RestaurantRepository;
import strategy.LowestPriceStrategy;
import strategy.RestaurantSelectionStrategy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {
    private OrderRepository orderRepository;
    private RestaurantRepository restaurantRepository;
    private RestaurantSelectionStrategy restaurantSelectionStrategy;
    private final AtomicInteger orderSequence = new AtomicInteger(0);

    public OrderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.restaurantSelectionStrategy = new LowestPriceStrategy();
    }

    public Order placeOrder(List<String> items) {
        if (items==null || items.isEmpty()) {
            throw new IllegalArguementException("Empty item list isn't allowed.");
        }

        List<Restaurant> restaurants = this.restaurantRepository.getRestaurants();

        Map<String, Restaurant> itemMap = this.restaurantSelectionStrategy.search(items, restaurants);

        if (itemMap.size()!=items.size()) {
            throw new NotFoundException("Order not fulfilable...");
        }

        Set<Restaurant> restaurantSet = new HashSet<>(itemMap.values());
        List<Restaurant> restaurantList = new ArrayList<>(restaurantSet);
        restaurantList.sort(Comparator.comparing(Restaurant::getId));

        return reserveAndOrder(items, itemMap, restaurantList);
    }

    private Order reserveAndOrder(List<String> itemIds, Map<String, Restaurant> itemMap, List<Restaurant> restaurants) {
        return acquireLocksRecursively(0, restaurants, () -> {
            Map<Restaurant, Integer> required = new HashMap<>();

            for (String itemId : itemIds) {
                Restaurant restaurant = itemMap.get(itemId);
                required.merge(restaurant, 1, Integer::sum);
            }

            for (Map.Entry<Restaurant, Integer> entry : required.entrySet()) {
                Restaurant restaurant = entry.getKey();
                int requiredCapacity = entry.getValue();
                if (!restaurant.isAvailableForOrder(requiredCapacity)) {
                    throw new OrderNotFulfillableException("Restaurant capacity changed. Please retry order.");
                }
            }

            for (Map.Entry<Restaurant, Integer> entry : required.entrySet()) {
                Restaurant restaurant = entry.getKey();
                int count = entry.getValue();
                for (int i = 0; i < count; i++) {
                    restaurant.reserveCapacity();
                }
            }

            String orderId = "#" + orderSequence.incrementAndGet();
            Order order = new Order(orderId);

            for (String itemId : itemIds) {
                Restaurant restaurant = itemMap.get(itemId);
                Item menuItem = restaurant.getMenu().getItem(itemId);
                Item orderItem = new Item(itemId, menuItem.getName(), menuItem.getPrice());
                order.addItem(restaurant, orderItem);
            }

            orderRepository.save(order);
            return order;
        });
    }

    private Order acquireLocksRecursively(int index, List<Restaurant> restaurants, OrderCreationTask task) {
        if (index==restaurants.size()) {
            return task.execute();
        }

        Restaurant restaurant = restaurants.get(index);

        synchronized (restaurant) {
            return acquireLocksRecursively(index+1, restaurants, task);
        }
    }

    @FunctionalInterface
    private interface OrderCreationTask {
        Order execute();
    }

    public void fulfillOrder(String orderId) {
        Order order = orderRepository.getOrder(orderId);
        if (order==null) {
            throw new NotFoundException("Order not found...");
        }

        synchronized (order) {
            if (order.getOrderStatus().name().equals(OrderStatus.DELIVERED.name())) {
                return;
            }

            Map<Restaurant, List<Item>> restaurantItems = order.getItems();

            for (Map.Entry<Restaurant, List<Item>> entry : restaurantItems.entrySet()) {
                Restaurant restaurant = entry.getKey();
                int count = entry.getValue().size();
                restaurant.replenishCapacity(count);
            }

            order.setOrderStatus(OrderStatus.DELIVERED);
        }
    }
}