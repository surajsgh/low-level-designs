package model;

import enums.ExpenseStatus;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class Expense {
    private String id;
    private User sender;
    private int amount;
    private ExpenseStatus expenseStatus;
    private Map<User, Integer> receivers;
    private LocalDateTime createdAt;

    public Expense(User sender, int amount, Map<User, Integer> receivers) {
        this.id = UUID.randomUUID().toString();
        this.sender = sender;
        this.amount = amount;
        this.receivers = receivers;
        this.expenseStatus = ExpenseStatus.PENDING;
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

    public Map<User, Integer> getReceivers() {
        return receivers;
    }

    public void updateStatus(ExpenseStatus expenseStatus) {
        this.expenseStatus = expenseStatus;
    }
}
