package model;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String emailId;
    private int balance;

    public User(String name, String emailId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.emailId = emailId;
        this.balance = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public int getBalance() {
        return balance;
    }

    public void subtractBalance(int amount) {
        this.balance -= amount;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }
}
