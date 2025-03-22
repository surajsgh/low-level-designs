import java.util.ArrayList;
import java.util.List;

public class InternalButtonDispatcher {
    List<ElevatorController> list;

    public InternalButtonDispatcher() {
        this.list = new ArrayList<>();
    }

    public void submitInternalRequest(int floor, ElevatorCar elevatorCar) {
        for (ElevatorController elevatorController: list) {
            if (elevatorController.elevatorCar.id==elevatorCar.id) {
                elevatorController.acceptNewRequest(floor, elevatorCar.currentFloor>floor ? Direction.DOWN : Direction.UP);
            }
        }
    }
}
