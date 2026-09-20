package strategy;

import model.Item;
import model.Restaurant;
import repository.RestaurantRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowestPriceStrategy implements RestaurantSelectionStrategy{
    @Override
    public Map<String, Restaurant> search(List<String> itemIds, List<Restaurant> restaurants) {
        Map<String, Restaurant> result = new HashMap<>();
        Map<Restaurant, Integer> restaurantCapacity = new HashMap<>();

        for (Restaurant restaurant: restaurants) {
            restaurantCapacity.put(restaurant, restaurant.getCurrentProcessingCapacity());
        }

        for (String itemId: itemIds) {
            Restaurant selectedRestaurant = null;
            int lowestPrice = Integer.MAX_VALUE;

            for (Restaurant restaurant: restaurants) {
                Item currentItem = restaurant.getMenu().getItem(itemId);
                boolean skipRecord = restaurant.getCurrentProcessingCapacity()<=0 || currentItem==null;
                if (skipRecord) {
                    continue;
                }

                if (currentItem.getPrice()<lowestPrice) {
                    selectedRestaurant = restaurant;
                    lowestPrice = currentItem.getPrice();
                }
            }

            if (selectedRestaurant==null) {
                return new HashMap<>();
            }

            result.put(itemId, selectedRestaurant);
            restaurantCapacity.put(selectedRestaurant, restaurantCapacity.get(selectedRestaurant)-1);
        }
        return result;
    }
}
