public class BasicRemote extends Remote{
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    void on() {
        device.on();
    }

    @Override
    void off() {
        device.off();
    }

    @Override
    void tuneChannel(int channel) {
        device.tuneChannel(channel);
    }
}
