public class VendingMachine {
    private VendingMachineState idleState;
    private VendingMachineState readyState;
    private VendingMachineState dispensingState;

    private VendingMachineState currentState;

    public VendingMachine() {
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispensingState = new DispensingState(this);
        currentState = idleState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.currentState = vendingMachineState;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public VendingMachineState getDispensingState() {
        return dispensingState;
    }

    public void insertCoin() {
        this.currentState.insertCoin();
    }

    public void pressButton() {
        this.currentState.pressButton();
    }

    public void dispense() {
        this.currentState.dispense();
    }
}
