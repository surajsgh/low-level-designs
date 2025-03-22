public class Floor {
    int floorId;
    ExternalButton button;
    int counter = 0;
    ElevatorCar elevatorCar;

    public Floor() {
        this.counter += 1;
        this.floorId = this.counter;
        this.button = new ExternalButton();
    }

    public void pressButton(Direction direction) {
        this.button.pressExternalButton(direction, getFloorId(), elevatorCar.id);
    }

    public int getFloorId() {
        return floorId;
    }
}
