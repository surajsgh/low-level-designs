public class ParkingSpot {
    private int id;
    private int idCounter = 0;
    private Status status;

    public ParkingSpot() {
        this.idCounter += 1;
        this.id = idCounter;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
}
