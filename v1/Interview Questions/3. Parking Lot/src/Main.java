public class Main {
    public static void main(String[] args) {
        DisplayBoard displayBoard = new DisplayBoard();
        ParkingAutomatedSystem automatedSystem = new ParkingAutomatedSystem();
        ParkingLot parkingLot = new ParkingLot("Thakur Complex", 100, "HSR Layout", displayBoard, 100, automatedSystem);
        System.out.println("Total available spots: " + parkingLot.getAvailability());

        Customer customer = new Customer("Suraj", "MH 04 DK 289");
        Ticket ticket = automatedSystem.generateTicket(customer);
        System.out.println(ticket);
        System.out.println(parkingLot.getAvailability());
    }
}