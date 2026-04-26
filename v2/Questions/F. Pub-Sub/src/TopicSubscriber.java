public class TopicSubscriber implements Subscriber{
    private String name;

    public TopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void inform(String message) {
        System.out.println(this.name + " received: " + message);
    }
}
