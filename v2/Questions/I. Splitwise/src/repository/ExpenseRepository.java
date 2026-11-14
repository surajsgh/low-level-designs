package repository;

import model.Expense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRepository {
    private static Map<String, Expense> expenses = new HashMap<>();

    public void save(Expense expense) {
        expenses.put(expense.getId(), expense);
    }

    public Expense getExpense(String id) {
        return expenses.get(id);
    }

    public List<Expense> getExpenses() {
        return new ArrayList<>(expenses.values());
    }
}
