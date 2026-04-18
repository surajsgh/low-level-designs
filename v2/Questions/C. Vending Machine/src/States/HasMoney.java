package States;

import Exceptions.VendingMachineExceptions;
import Services.Slot;
import Services.VendingMachine;

public class HasMoney implements State {

    @Override
    public void selectProduct(VendingMachine vendingMachine, Slot slotId) {
        throw new VendingMachineExceptions();
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        vendingMachine.getPaymentStrategy().pay(amount);
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        vendingMachine.dispenseProduct();
        vendingMachine.setCurrentState(new IdleState());
    }
}
