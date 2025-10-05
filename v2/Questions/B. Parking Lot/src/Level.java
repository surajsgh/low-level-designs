import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Level {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private int id;
    private List<ParkingSpot> parkingSpots;

    public Level(List<ParkingSpot> parkingSpots) {
        this.id = counter.getAndIncrement();
        this.parkingSpots = parkingSpots;
    }

    public int totalAvailableSpots() {
        return this.parkingSpots.stream().filter(parkingSpot -> !parkingSpot.isOccupied()).toList().size();
    }

    public ParkingSpot park(Vehicle vehicle) {
        for (ParkingSpot parkingSpot: parkingSpots) {
            if (parkingSpot.isAvailable(vehicle)) {
                parkingSpot.assign(vehicle);
                return parkingSpot;
            }
        }
        System.out.println("Oops, found no parking spot");
        return null;
    }

    public void release(ParkingSpot allottedParkingSpot) {
        for (ParkingSpot parkingSpot: parkingSpots) {
            if (parkingSpot == allottedParkingSpot) {
                parkingSpot.release();
            }
        }
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", parkingSpots=" + parkingSpots +
                '}';
    }
}
