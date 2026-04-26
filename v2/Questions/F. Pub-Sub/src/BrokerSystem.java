import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BrokerSystem {
    private ConcurrentMap<String, Topic> topics = new ConcurrentHashMap<>();
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void addTopic(Topic topic) {
        topics.put(topic.getName(), topic);
    }

    public void publishMessage(Topic topic, Message message) {
        this.validateTopic(topic);
        for (Subscriber subscriber: topic.getSubscribers()) {
            executorService.submit(() -> subscriber.inform(message.getPayload()));
        }
    }

    public void subscribe(Topic topic, Subscriber subscriber) {
        this.validateTopic(topic);
        topic.addNewSubscriber(subscriber);
    }

    public void shutDown() {
        this.executorService.shutdown();
    }

    private void validateTopic(Topic topic) {
        if (!topics.containsKey(topic.getName())) {
            System.out.println("This topic doesn't exist.");
            return;
        }
    }
}
