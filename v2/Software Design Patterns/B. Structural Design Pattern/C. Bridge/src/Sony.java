public class Sony implements Device{
    @Override
    public void on() {
        System.out.println("Sony TV is turned ON!");
    }

    @Override
    public void off() {
        System.out.println("Sony TV is turned OFF!");
    }

    @Override
    public void tuneChannel(int channel) {
        System.out.println("TV is turned to channel " + channel);
    }
}
