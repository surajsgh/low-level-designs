public class Vehicle {
    int id;
    int counter = 0;
    String vehicle;
    VehicleType vehicleType;
    Status status;
    int chargePerMin;
    int chargePerHr;

    public Vehicle(String vehicle, int chargePerMin, int chargePerHr) {
        this.counter += 0;
        this.id = this.counter;
        this.vehicle = vehicle;
        this.vehicleType = VehicleType.CAR;
        this.status = Status.AVAILABLE;
        this.chargePerMin = chargePerMin;
        this.chargePerHr = chargePerHr;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getChargePerMin() {
        return chargePerMin;
    }

    public void setChargePerMin(int chargePerMin) {
        this.chargePerMin = chargePerMin;
    }

    public int getChargePerHr() {
        return chargePerHr;
    }

    public void setChargePerHr(int chargePerHr) {
        this.chargePerHr = chargePerHr;
    }
}
