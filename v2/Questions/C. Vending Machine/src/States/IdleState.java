package States;

import Exceptions.VendingMachineExceptions;
import Services.Slot;
import Services.VendingMachine;

public class IdleState implements State{

    @Override
    public void selectProduct(VendingMachine vendingMachine, Slot slotId) {
        vendingMachine.selectProduct(slotId);
        vendingMachine.setCurrentState(new HasMoney());
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        throw new VendingMachineExceptions();
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        throw new VendingMachineExceptions();
    }
}
