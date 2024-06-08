import java.time.LocalDateTime;

public class Reservation {
    int id;
    int counter;
    Vehicle vehicle;
    LocalDateTime dateTime;
    ReservationStatus reservationStatus;
    Location from;
    Location to;

    public Reservation(Vehicle vehicle, Location from, Location to) {
        this.counter += 0;
        this.id = this.counter;
        this.vehicle = vehicle;
        this.dateTime = LocalDateTime.now();
        this.reservationStatus = ReservationStatus.PENDING;
        this.from = from;
        this.to = to;
    }
}
