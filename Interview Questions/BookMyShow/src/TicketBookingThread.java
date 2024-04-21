public class TicketBookingThread extends Thread {
    private Show show;
    private Ticket ticket;
    private RegisteredUser user;
    private int seats;

    public TicketBookingThread(Show show, RegisteredUser user, int seats) {
        this.show = show;
        this.user = user;
        this.seats = seats;
    }

    @Override
    public void run() {
        this.ticket = show.bookTicket(user, seats);
    }

    public Ticket getTicket() {
        return this.ticket;
    }
}
