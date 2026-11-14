package service;

import enums.ExpenseStatus;
import model.Expense;
import model.SenderReceiverMap;
import model.User;
import repository.SenderReceiverMapRepository;
import repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository userRepository;
    private SenderReceiverMapRepository senderReceiverMapRepository;

    public UserService(UserRepository userRepository, SenderReceiverMapRepository senderReceiverMapRepository) {
        this.userRepository = userRepository;
        this.senderReceiverMapRepository = senderReceiverMapRepository;
    }

    public void registerUser(User user) {
        this.userRepository.save(user);
    }

    public void getExpenseHistory(User user) {
        List<SenderReceiverMap> list = this.senderReceiverMapRepository.getSenderReceiverList().stream().filter(mapList ->
                mapList.getExpenseStatus().equals(ExpenseStatus.PENDING)).toList();

        for (SenderReceiverMap listItem: list) {
            if (listItem.getSender().getId().equals(user.getId())) {
                System.out.println(listItem.getReceiver().getName() + " owes you " + listItem.getAmount() + ".");
            }
        }

        for (SenderReceiverMap listItem: list) {
            if (listItem.getReceiver().getId().equals(user.getId())) {
                System.out.println("You owe " + listItem.getReceiver().getName() + " " + listItem.getAmount() + ".");
            }
        }
    }
}
