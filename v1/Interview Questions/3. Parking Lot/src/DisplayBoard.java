public class DisplayBoard {
    private int id;
    private Status status;

    public DisplayBoard() {
        this.status = Status.AVAILABLE;
    }

    public void updateStatus(Status newStatus) {
        this.status = newStatus;
    }
}
