package model;

import exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<String, Item> items;

    public Menu() {
        this.items = new HashMap<>();
    }

    public synchronized List<Item> getItems() {
        return new ArrayList<>(this.items.values());
    }

    public synchronized void addItem(Item item) {
        this.items.put(item.getId(), item);
    }

    public synchronized void removeItem(Item item) {
        this.items.remove(item.getId());
    }

    public synchronized void updateItemPrice(Item item, int newPrice) {
        Item existingItem = this.items.get(item.getId());

        if (existingItem==null) {
            throw new NotFoundException("Invalid Item: " + item);
        }

        existingItem.setPrice(newPrice);
    }

    public synchronized Item getItem(String itemId) {
        return this.items.get(itemId);
    }
}
