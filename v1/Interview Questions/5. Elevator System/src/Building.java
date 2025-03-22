import java.util.ArrayList;
import java.util.List;

public class Building {
    List<Floor> floors;

    public Building() {
        this.floors = new ArrayList<Floor>();
    }

    public void addFloor(Floor floor) {
        this.getFloors().add(floor);
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
