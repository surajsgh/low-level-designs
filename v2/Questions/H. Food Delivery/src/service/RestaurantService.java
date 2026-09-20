package service;

import exception.NotFoundException;
import model.Item;
import model.Restaurant;
import repository.RestaurantRepository;

public class RestaurantService {
    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void addRestaurant(Restaurant restaurant) {
        if (restaurant==null) {
            throw new NotFoundException("Invalid Input");
        }

        this.restaurantRepository.save(restaurant);
    }

    public void showSummary() {
        for (Restaurant restaurant: this.restaurantRepository.getRestaurants()) {
            System.out.println(restaurant.getName() + " " + restaurant.getMaximumProcessingCapacity());
        }
    }

    public void addItem(String restaurantId, Item item) {
        Restaurant restaurant = this.restaurantRepository.getRestaurant(restaurantId);
        if (restaurant==null) {
            throw new NotFoundException("Invalid restaurant id");
        }

        restaurant.getMenu().addItem(item);
    }

    public void removeItem(String restaurantId, Item item) {
        Restaurant restaurant = this.restaurantRepository.getRestaurant(restaurantId);
        if (restaurant==null) {
            throw new NotFoundException("Invalid restaurant id");
        }

        restaurant.getMenu().removeItem(item);
    }

    public void updateMenuItemPrice(String restaurantId, String itemId, int newPrice) {
        Restaurant restaurant = this.restaurantRepository.getRestaurant(restaurantId);
        if (restaurant==null) {
            throw new NotFoundException("Invalid restaurant id");
        }

        restaurant.getMenu().getItem(itemId).setPrice(newPrice);
    }
}
