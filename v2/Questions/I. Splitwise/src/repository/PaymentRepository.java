package repository;

import model.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {
    private static Map<String, Payment> payments = new HashMap<>();

    public void save(Payment payment) {
        payments.put(payment.getId(), payment);
    }
}
