public class DispensingState implements VendingMachineState{
    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Wait, dispensing is in progress");
    }

    @Override
    public void pressButton() {
        System.out.println("Wait, dispensing is in progress");
    }

    @Override
    public void dispense() {
        System.out.println("Product is dispensed");
        this.vendingMachine.setVendingMachineState(vendingMachine.getIdleState());
    }
}
