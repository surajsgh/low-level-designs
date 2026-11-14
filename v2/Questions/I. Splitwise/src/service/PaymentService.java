package service;

import model.Payment;
import model.SenderReceiverMap;
import model.User;
import repository.PaymentRepository;
import repository.SenderReceiverMapRepository;

import java.util.List;

public class PaymentService {
    private PaymentRepository paymentRepository;
    private SenderReceiverMapRepository senderReceiverMapRepository;

    public PaymentService(PaymentRepository paymentRepository, SenderReceiverMapRepository senderReceiverMapRepository) {
        this.paymentRepository = paymentRepository;
        this.senderReceiverMapRepository = senderReceiverMapRepository;
    }

    public void pay(User sender, User receiver, int amount, String expenseId) {
//        SenderReceiverMap expense = this.senderReceiverMapRepository.getExpense(expenseId).stream().filter(exp -> exp.getReceiver().getId().equals(receiver.getId()));
//        expense.
        // amount update
        sender.addBalance(amount);
        receiver.subtractBalance(amount);
        // Later on step
        Payment payment = new Payment(sender, amount, receiver);
        this.paymentRepository.save(payment);
    }
}
