package States;

import Services.Slot;
import Services.VendingMachine;

public interface State {
    void selectProduct(VendingMachine vendingMachine, Slot slotId);
    void insertMoney(VendingMachine vendingMachine, int amount);
    void dispense(VendingMachine vendingMachine);
}
