import java.io.File;

public class LogSubscriber implements EventListener{
    private String name;

    public LogSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String event, File file) {
        System.out.println("Log to " + this.name + ": Someone has performed " + event + " on the file, " + file.getName() + ".");
    }
}
