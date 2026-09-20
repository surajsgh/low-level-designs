package repository;

import model.Order;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OrderRepository {
    private static final Map<String, Order> map = new ConcurrentHashMap<>();

    public void save(Order order) {
        map.put(order.getId(), order);
    }

    public Order getOrder(String id) {
        return map.get(id);
    }
}
