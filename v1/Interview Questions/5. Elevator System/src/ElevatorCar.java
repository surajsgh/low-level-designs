public class ElevatorCar {
    int id;
    int counter = 0;
    Display display;
    int currentFloor;
    Direction direction;
    Status status;
    InternalButton button;

    public ElevatorCar() {
        this.counter += 1;
        this.id = this.counter;
        this.display = new Display(0, Direction.NOTHING);
        this.currentFloor = 0;
        this.direction = Direction.NOTHING;
        this.status = Status.STILL;
        this.button = new InternalButton();
    }

    public void move(int destinationFloor, Direction direction) {

    }

}
