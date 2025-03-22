import java.util.ArrayList;

public class RegisteredUser extends User {
    private ArrayList<Ticket> bookingHistory;

    public RegisteredUser(String name) {
        super(name);
        this.bookingHistory = new ArrayList<>();
    }
}
