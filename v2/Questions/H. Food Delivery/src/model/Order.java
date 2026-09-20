package model;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
    private String id;
    private Map<Restaurant, List<Item>> items;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;

    public Order(String id) {
        this.id = id;
        this.items = new HashMap<>();
        this.orderStatus = OrderStatus.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Map<Restaurant, List<Item>> getItems() {
        return items;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void addItem(Restaurant restaurant, Item item) {
        this.items.computeIfAbsent(restaurant, r -> new ArrayList<>()).add(item);
    }
}
