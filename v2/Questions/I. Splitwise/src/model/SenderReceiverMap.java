package model;

import enums.ExpenseStatus;

import java.util.UUID;

public class SenderReceiverMap {
    private String id;
    private String expenseId;
    private User sender;
    private User receiver;
    private int amount;
    private ExpenseStatus expenseStatus;

    public SenderReceiverMap(String expenseId, User sender, User receiver, int amount) {
        this.id = UUID.randomUUID().toString();
        this.expenseId = expenseId;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.expenseStatus = ExpenseStatus.PENDING;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public ExpenseStatus getExpenseStatus() {
        return expenseStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void updateStatus(ExpenseStatus expenseStatus) {
        this.expenseStatus = expenseStatus;
    }
}
