package strategy;

import model.Customer;

import java.util.logging.Logger;

public class CreditCardPayment implements PaymentStrategy{
    private final static Logger logger = Logger.getLogger(CreditCardPayment.class.getName());
    @Override
    public void pay(double amount, Customer customer) {
        logger.info("Credit card payment successful: " + amount + ", By " + customer.getName());
    }
}
