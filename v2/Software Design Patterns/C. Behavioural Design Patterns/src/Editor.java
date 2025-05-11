import java.io.File;

public class Editor {
    private EventManager eventManager;
    private File file;

    public Editor() {
        this.eventManager = new EventManager("open", "save");
    }

    public void open(String fileName) {
        this.file = new File(fileName);
        eventManager.notifySubscribers("open", this.file);
    }

    public void close(String fileName) throws Exception {
        if (fileName!=null) {
            eventManager.notifySubscribers("save", this.file);
        }
        else {
            throw new Exception("Please open the file first");
        }
    }

    public EventManager getEventManager() {
        return eventManager;
    }
}
