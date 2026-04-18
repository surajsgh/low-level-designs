package Services;

import Exceptions.OutOfStockExceptions;

import java.util.concurrent.atomic.AtomicInteger;

public class Slot {
    private static AtomicInteger counter = new AtomicInteger(0);
    private int slotId;
    private Product product;
    private int quantity;

    public Slot(Product product, int quantity) {
        this.slotId = counter.getAndIncrement();
        this.product = product;
        this.quantity = quantity;
    }

    public synchronized void dispense(int quantity) {
        if (this.quantity<=0) throw new OutOfStockExceptions();
        this.quantity -= quantity;
    }

    public synchronized void restock(int quantity) {
        this.quantity += quantity;
    }

    public int totalPrice() {
        return this.product.getPrice() * this.quantity;
    }

    public int getSlotId() {
        return slotId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
