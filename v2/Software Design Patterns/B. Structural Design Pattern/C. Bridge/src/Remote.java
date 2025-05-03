abstract class Remote {
    Device device;

    public Remote(Device device) {
        this.device = device;
    }

    abstract void on();
    abstract void off();
    abstract void tuneChannel(int channel);
}
