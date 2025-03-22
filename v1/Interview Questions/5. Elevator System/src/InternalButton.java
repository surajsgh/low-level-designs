public class InternalButton {
    InternalButtonDispatcher buttonDispatcher;

    public InternalButton() {
        this.buttonDispatcher = new InternalButtonDispatcher();
    }

    public void pressButton(int floor, ElevatorCar elevatorCar) {
        buttonDispatcher.submitInternalRequest(floor, elevatorCar);
    }
}
