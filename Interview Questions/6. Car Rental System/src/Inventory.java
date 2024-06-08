import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Vehicle> list;

    public Inventory() {
        this.list = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.list.add(vehicle);
    }

    public List<Vehicle> getVehicle() {
        return list;
    }
}
