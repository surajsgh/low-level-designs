import java.util.ArrayList;

public class ParkingLot {
    private int id;
    private String name;
    private int capacity;
    private String location;
    private DisplayBoard board;
    private ArrayList<ParkingSpot> parkingSpots;
    private ArrayList<ParkingSpot> availableParkingSpots;
    private int parkingCharges;
    private ParkingAutomatedSystem automatedSystem;

    public ParkingLot(String name, int capacity, String location, DisplayBoard board, int parkingCharges, ParkingAutomatedSystem automatedSystem) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
        this.board = board;
        this.parkingSpots = createParkingSpots(capacity);
        this.availableParkingSpots = this.parkingSpots;
        this.parkingCharges = parkingCharges;
        this.automatedSystem = automatedSystem;
        this.automatedSystem.setParkingLot(this);
    }

    public ArrayList<ParkingSpot> createParkingSpots(int capacity) {
        ArrayList<ParkingSpot> list = new ArrayList<>();
        for (int i=0; i<capacity; i++) {
            list.add(new ParkingSpot());
        }
        return list;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    public DisplayBoard getBoard() {
        return board;
    }

    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public ArrayList<ParkingSpot> getAvailableParkingSpots() {
        return availableParkingSpots;
    }

    public int getParkingCharges() {
        return parkingCharges;
    }

    public ParkingAutomatedSystem getAutomatedSystem() {
        return automatedSystem;
    }

    public ParkingSpot getAvailableSpot() {
        return this.availableParkingSpots.remove(0);
    }

    public int getAvailability() {
        //  Code implementation
        return availableParkingSpots.size();
    }

    public void setParkingCharges(int parkingCharges) {
        this.parkingCharges = parkingCharges;
    }
}
