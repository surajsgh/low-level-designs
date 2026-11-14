package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private String id;
    private User sender;
    private int amount;
    private User receiver;
    private LocalDateTime createdAt;

    public Payment(User sender, int amount, User receiver) {
        this.id = UUID.randomUUID().toString();
        this.sender = sender;
        this.amount = amount;
        this.receiver = receiver;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public int getAmount() {
        return amount;
    }

    public User getReceiver() {
        return receiver;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
