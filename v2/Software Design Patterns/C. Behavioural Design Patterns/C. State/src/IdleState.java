public class IdleState implements VendingMachineState{
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted");
        this.vendingMachine.setVendingMachineState(vendingMachine.getReadyState());
    }

    @Override
    public void pressButton() {
        System.out.println("Insert coin first.");
    }

    @Override
    public void dispense() {
        System.out.println("Insert coin first.");
    }
}
