import java.util.ArrayList;
import java.util.List;

public class ExternalButtonDispatcher {
    List<ElevatorController> list;

    public ExternalButtonDispatcher() {
        list = new ArrayList<>();
    }

    public void submitExternalRequest(int floor, int id) {
        for (ElevatorController elevatorController: list) {
            if (elevatorController.elevatorCar.id==id) {
                System.out.println("Welcome");
            }
        }
    }
}
