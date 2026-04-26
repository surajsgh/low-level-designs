import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Topic {
    private String name;
    private List<Subscriber> subscribers = new CopyOnWriteArrayList<>();

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNewSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}
