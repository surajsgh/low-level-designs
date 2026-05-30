package strategy;

import model.Customer;

public interface PaymentStrategy {
    void pay(double amount, Customer customer);
}
