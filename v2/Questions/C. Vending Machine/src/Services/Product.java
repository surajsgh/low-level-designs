package Services;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private AtomicInteger counter = new AtomicInteger(0);
    private int productId;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.productId = counter.getAndIncrement();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }
}
