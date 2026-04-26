public class Main {
    public static void main(String[] args) {
        BrokerSystem brokerSystem = new BrokerSystem();
        Topic topic = new Topic("DAPI");

        Subscriber allocation = new TopicSubscriber("Allocation");
        Subscriber dapp = new TopicSubscriber("Dapp");

        brokerSystem.addTopic(topic);
        brokerSystem.subscribe(topic, allocation);
        brokerSystem.subscribe(topic, dapp);

        brokerSystem.publishMessage(topic, new Message("Booking completed"));
        brokerSystem.shutDown();
    }
}