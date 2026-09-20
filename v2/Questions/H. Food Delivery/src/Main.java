import repository.OrderRepository;
import repository.RestaurantRepository;
import service.OrderService;
import service.RestaurantService;
import strategy.LowestPriceStrategy;
import model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        OrderRepository orderRepository = new OrderRepository();
        RestaurantService restaurantService = new RestaurantService(restaurantRepository);
        OrderService orderService = new OrderService(orderRepository, restaurantRepository);
        LowestPriceStrategy lowestPriceStrategy = new LowestPriceStrategy();

        Menu a2bMenu = new Menu();

        a2bMenu.addItem(new Item("IDLY", "Idly", 40));
        a2bMenu.addItem(new Item("VADA", "Vada", 30));
        a2bMenu.addItem(new Item("PAPER_PLAIN_DOSA", "Paper Plain Dosa", 50));

        Restaurant a2b = new Restaurant("R1", "A2B", a2bMenu, 4);
        restaurantService.addRestaurant(a2b);

        Menu rasagangaMenu = new Menu();
        rasagangaMenu.addItem(new Item("IDLY", "Idly", 45));
        rasagangaMenu.addItem(new Item("SET_DOSA", "Set Dosa", 60));
        rasagangaMenu.addItem(new Item("POORI", "Poori", 25));

        Restaurant rasaganga = new Restaurant("R2", "Rasaganga", rasagangaMenu, 6);
        restaurantService.addRestaurant(rasaganga);

        Menu eatFitMenu = new Menu();
        eatFitMenu.addItem(new Item("IDLY", "Idly", 30));
        eatFitMenu.addItem(new Item("VADA", "Vada", 40));

        Restaurant eatFit = new Restaurant("R3", "Eat Fit", eatFitMenu, 2);
        restaurantService.addRestaurant(eatFit);

        Order order1 = orderService.placeOrder(List.of("IDLY", "POORI"));
        System.out.println("Order Id" + order1.getId() + " : Ordered from " + getRestaurantNames(order1));

        Order order2 = orderService.placeOrder(List.of("IDLY", "VADA"));
        System.out.println("Order Id" + order2.getId() + " : Ordered from " + getRestaurantNames(order2));

        printStats(restaurantRepository);

        orderService.fulfillOrder(order1.getId());
        orderService.fulfillOrder(order2.getId());

        Order order3 = orderService.placeOrder(List.of("IDLY"));
        System.out.println("Order Id" + order3.getId() + " : Ordered from " + getRestaurantNames(order3));
    }

    private static String getRestaurantNames(Order order) {
        return order.getItems().keySet().stream().map(Restaurant::getName).reduce((a, b) -> a + " & " + b).orElse("");
    }

    private static void printStats(RestaurantRepository repository) {
        System.out.println("Restaurant Processing Capacity:");
        repository.getRestaurants().stream().sorted(java.util.Comparator.comparing(Restaurant::getId))
                .forEach(restaurant -> System.out.println(restaurant.getName() + ": " + restaurant.getCurrentProcessingCapacity()));
    }
}