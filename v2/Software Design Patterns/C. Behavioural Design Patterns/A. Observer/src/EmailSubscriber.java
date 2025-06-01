import java.io.File;

public class EmailSubscriber implements EventListener{
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String event, File file) {
        System.out.println("Email to " + this.email + ": Someone has performed " + event + " on the file, " + file.getName() + ".");
    }
}
