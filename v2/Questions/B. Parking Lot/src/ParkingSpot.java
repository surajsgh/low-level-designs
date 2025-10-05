import java.util.concurrent.atomic.AtomicInteger;

public class ParkingSpot {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private int id;
    private boolean isOccupied;
    private Vehicle vehicle;
    private VehicleType spotVehicleType;

    public ParkingSpot(boolean isOccupied, Vehicle vehicle, VehicleType spotVehicleType) {
        this.id = counter.getAndIncrement();
        this.isOccupied = isOccupied;
        this.vehicle = vehicle;
        this.spotVehicleType = spotVehicleType;
    }

    public boolean isAvailable(Vehicle entryVehicle) {
        return !this.isOccupied && vehicle==null && this.spotVehicleType==entryVehicle.getVehicleType();
    }

    public void assign(Vehicle entryVehicle) {
        if (!isAvailable(entryVehicle)) System.out.println("No space available");
        this.isOccupied = true;
        this.vehicle = entryVehicle;
    }

    public void release() {
        this.isOccupied = false;
        this.vehicle = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
