package service;

import exception.NotFoundException;
import model.Expense;
import model.SenderReceiverMap;
import model.User;
import repository.ExpenseRepository;
import repository.SenderReceiverMapRepository;
import repository.UserRepository;

import java.util.Map;

public class ExpenseService {
    private ExpenseRepository expenseRepository;
    private UserRepository userRepository;
    private SenderReceiverMapRepository senderReceiverMapRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository, SenderReceiverMapRepository senderReceiverMapRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.senderReceiverMapRepository = senderReceiverMapRepository;
    }

    public void registerExpense(User sender, int amount, Map<User, Integer> receivers) {
        if (this.userRepository.getUser(sender.getId())==null) {
            throw new NotFoundException("User Not Found...");
        }

        Expense expense = new Expense(sender, amount, receivers);

        for (Map.Entry<User, Integer> entry: receivers.entrySet()) {
            User receiver = entry.getKey();
            int expenseAmount = entry.getValue();
            SenderReceiverMap senderReceiverMap = new SenderReceiverMap(expense.getId(), sender, receiver, expenseAmount);

            receiver.subtractBalance(expenseAmount);
            this.senderReceiverMapRepository.save(senderReceiverMap);
        }

        sender.addBalance(amount);
        this.expenseRepository.save(expense);
    }
}
