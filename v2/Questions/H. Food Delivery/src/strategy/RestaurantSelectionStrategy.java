package strategy;

import model.Item;
import model.Restaurant;

import java.util.*;

public interface RestaurantSelectionStrategy {
    Map<String, Restaurant> search(List<String> itemIds, List<Restaurant> restaurants);
}
