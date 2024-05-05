import java.time.LocalDateTime;

public class Ticket {
    private int idCounter = 0;
    private int id;
    private String vehicleRegistrationNumber;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private int parkingCharges;
    private int parkingSpotNo;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.idCounter += 1;
        this.id = idCounter;
        this.vehicleRegistrationNumber = vehicle.getVehicleNo();
        this.arrivalTime = LocalDateTime.now();
        this.parkingSpotNo = parkingSpot.getId();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idCounter=" + idCounter +
                ", id=" + id +
                ", vehicleRegistrationNumber='" + vehicleRegistrationNumber + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", parkingCharges=" + parkingCharges +
                ", parkingSpotNo=" + parkingSpotNo +
                '}';
    }
}
