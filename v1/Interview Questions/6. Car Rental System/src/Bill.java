public class Bill {
    Reservation reservation;
    boolean isPaid;
    double amount;

    public Bill(Reservation reservation, boolean isPaid, double amount) {
        this.reservation = reservation;
        this.isPaid = isPaid;
        this.amount = amount;
    }


}
