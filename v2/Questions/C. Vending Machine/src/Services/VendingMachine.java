package Services;

import Exceptions.InsufficientFundsException;
import Exceptions.InvalidSelectionException;
import Payments.PaymentStrategy;
import States.IdleState;
import States.State;

public class VendingMachine {
    private Catalogue catalogue;
    private ChangeService changeService;
    private PaymentStrategy paymentStrategy;
    private State currentState;
    private Slot selectedSlot;

    public VendingMachine(Catalogue catalogue, ChangeService changeService, PaymentStrategy paymentStrategy) {
        this.catalogue = catalogue;
        this.changeService = changeService;
        this.paymentStrategy = paymentStrategy;
        this.currentState = new IdleState();
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void selectProduct(Slot slotId) {
        this.currentState.selectProduct(this, slotId);
    }

    public void payMoney(int amount) {
        this.currentState.insertMoney(this, amount);
    }

    public void dispense() {
        this.currentState.dispense(this);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setSelectedSlot(Slot selectedSlot) {
        this.selectedSlot = selectedSlot;
    }

    public Slot getSelectedSlot() {
        return selectedSlot;
    }

    public synchronized void dispenseProduct() {
        // Dispense Logic
        Slot slot = catalogue.getSlot(this.selectedSlot.getSlotId());
        if (slot==null) throw new InvalidSelectionException();

        Product product = slot.getProduct();
        if (product==null) throw new InvalidSelectionException();

        if (paymentStrategy.totalAmount() < slot.totalPrice()) throw new InsufficientFundsException();

        slot.dispense(product.getProductId());

        int change = paymentStrategy.totalAmount() - slot.totalPrice();
        if (change>0) {
            System.out.println("Change: " + this.changeService.getChange(change));
        }

        paymentStrategy.reset();
    }
}
