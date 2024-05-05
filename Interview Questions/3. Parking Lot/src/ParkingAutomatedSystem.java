import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class ParkingAutomatedSystem {
    private int id;
    private ParkingLot parkingLot;
    HashMap<Integer, Ticket> currentTickets;

    public ParkingAutomatedSystem() {
        this.currentTickets = new HashMap<>();
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket generateTicket(Customer customer) {
        ParkingSpot parkingSpot = parkingLot.getAvailableSpot();
        Vehicle vehicle = customer.getVehicle();
        Ticket ticket = new Ticket(vehicle, parkingSpot);
        currentTickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public void openEntryBarrier() {

    }

    public void openExitBarrier() {

    }

    public void generateTicket() {

    }

    public long calculateCharges() {
        Ticket ticket = scanTicket();
        long duration = Duration.between(LocalDateTime.now(), ticket.getArrivalTime()).toHours();
        return duration*parkingLot.getParkingCharges();
    }

    public Ticket scanTicket() {
        return currentTickets.get(1);
    }
}
