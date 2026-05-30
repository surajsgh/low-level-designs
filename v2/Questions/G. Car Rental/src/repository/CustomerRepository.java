package repository;

import model.Customer;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerRepository {
    private static final Map<String, Customer> map = new ConcurrentHashMap<>();

    public void save(Customer customer) {
        map.put(customer.getId(), customer);
    }

    public Customer getCustomerById(String customerId) {
        return map.get(customerId);
    }

    public Collection<Customer> getCustomers() {
        return map.values();
    }
}
