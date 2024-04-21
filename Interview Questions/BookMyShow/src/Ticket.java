import java.util.Date;

public class Ticket {
    private static int idCounter = 0;
    private int id;
    private String name;
    private int seat;
    private Date bookingDate;
    private Show show;

    public Ticket(String name, int seat, Date bookingDate, Show show) {
        idCounter += 1;
        this.id = idCounter;
        this.name = name;
        this.seat = seat;
        this.bookingDate = bookingDate;
        this.show = show;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seat=" + seat +
                ", bookingDate=" + bookingDate +
                ", show=" + show +
                '}';
    }
}
