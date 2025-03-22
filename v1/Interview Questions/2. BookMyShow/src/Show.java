import java.util.Date;

public class Show {
    private static int idCounter = 0;
    private int id;
    private Date dateTime;
    private int availableSeats;
    private Movie movie;
    private Theater theater;

    public Show(Date dateTime, Movie movie, Theater theater) {
        idCounter += 1;
        this.id = idCounter;
        this.dateTime = dateTime;
        this.movie = movie;
        this.theater = theater;
        this.availableSeats = theater.getCapacity();
        theater.getShows().add(this);
    }

    public synchronized Ticket bookTicket(RegisteredUser user, int seats) {
        if (this.getAvailableSeats()>=seats && seats>0) {
            availableSeats -= seats;
            Ticket ticket = new Ticket(user.getName(), seats, new Date(), this);
            System.out.println("Successfully booked...");
            return ticket;
        }
        else {
            System.out.println("Seats not available.");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", availableSeats=" + availableSeats +
                ", movie=" + movie +
                ", theater=" + theater +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
