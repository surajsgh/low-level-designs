package Payments;

public class OfflinePayment implements PaymentStrategy{
    private int total = 0;

    @Override
    public void pay(int amount) {
        this.total += amount;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public int totalAmount() {
        return this.total;
    }

    @Override
    public void reset() {
        this.total = 0;
    }
}
