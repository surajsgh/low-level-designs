public class ReadyState implements VendingMachineState{
    private VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin is already inserted.");
    }

    @Override
    public void pressButton() {
        System.out.println("Button pressed.");
        this.vendingMachine.setVendingMachineState(vendingMachine.getDispensingState());
    }

    @Override
    public void dispense() {
        System.out.println("Press button first.");
    }
}
