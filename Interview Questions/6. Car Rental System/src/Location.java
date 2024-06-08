public class Location {
    int pincode;
    String firstAddress;
    String secondAddress;
    String state;
    String city;

    public Location(int pincode, String firstAddress, String secondAddress, String state, String city) {
        this.pincode = pincode;
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.state = state;
        this.city = city;
    }
}
