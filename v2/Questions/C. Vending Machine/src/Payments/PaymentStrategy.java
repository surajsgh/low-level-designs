package Payments;

public interface PaymentStrategy {
    void pay(int amount);
    int totalAmount();
    void reset();
}
