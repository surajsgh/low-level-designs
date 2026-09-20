package model;

import exception.IllegalArguementException;

public class Restaurant {
    private String id;
    private String name;
    private Menu menu;
    private int maximumProcessingCapacity;
    private int currentProcessingCapacity;

    public Restaurant(String id, String name, Menu menu, int maximumProcessingCapacity) {
        this.id = id;
        this.name = name;
        this.menu = menu;
        this.maximumProcessingCapacity = maximumProcessingCapacity;
        this.currentProcessingCapacity = maximumProcessingCapacity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getMaximumProcessingCapacity() {
        return maximumProcessingCapacity;
    }

    public int getCurrentProcessingCapacity() {
        return currentProcessingCapacity;
    }

    public boolean isAvailableForOrder(int count) {
        return this.currentProcessingCapacity >= count;
    }

    public synchronized boolean reserveCapacity() {
        if (this.currentProcessingCapacity<=0) {
            return false;
        }
        this.currentProcessingCapacity--;
        return true;
    }

    public synchronized void replenishCapacity(int count) {
        if (count<=0) {
            throw new IllegalArguementException("Count can not be below zero.");
        }
        this.currentProcessingCapacity = Math.min(this.maximumProcessingCapacity, this.currentProcessingCapacity + count);
    }
}
