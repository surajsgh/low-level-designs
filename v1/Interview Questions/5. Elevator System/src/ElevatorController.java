import java.util.Collections;
import java.util.PriorityQueue;

public class ElevatorController {
    PriorityQueue<Integer> asc;
    PriorityQueue<Integer> desc;
    ElevatorCar elevatorCar;

    public ElevatorController(ElevatorCar elevatorCar) {
        asc = new PriorityQueue<>();
        desc = new PriorityQueue<>(Collections.reverseOrder());
        this.elevatorCar = elevatorCar;
    }

    public void acceptNewRequest(int floor, Direction direction) {
        if (direction == Direction.UP) {
            asc.offer(floor);
        }
        else if (direction == Direction.DOWN) {
            desc.offer(floor);
        }
    }
}
