import java.io.File;
import java.util.*;

public class EventManager {
    private Map<String, List<EventListener>> map = new HashMap<>();

    public EventManager(String... events) {
        for (String event: events) {
            map.put(event, new ArrayList<>());
        }
    }

    public void subscribe(String event, EventListener listener) {
        map.get(event).add(listener);
    }

    public void unsubscribe(String event, EventListener listener) {
        map.get(event).remove(listener);
    }

    public void notifySubscribers(String event, File file) {
        List<EventListener> listeners = map.get(event);
        for (EventListener listener: listeners) {
            listener.update(event, file);
        }
    }
}
