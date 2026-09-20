package repository;

import model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RestaurantRepository {
    private static final Map<String, Restaurant> map = new ConcurrentHashMap<>();

    public void save(Restaurant restaurant) {
        map.put(restaurant.getId(), restaurant);
    }

    public Restaurant getRestaurant(String id) {
        return map.get(id);
    }

    public List<Restaurant> getRestaurants() {
        return new ArrayList<>(map.values());
    }
}
