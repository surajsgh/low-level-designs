public abstract class Vehicle {
    private String numberPlate;
    private VehicleType vehicleType;

    public Vehicle(String numberPlate, VehicleType vehicleType) {
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

class Car extends Vehicle {
    public Car(String numberPlate, VehicleType vehicleType) {
        super(numberPlate, vehicleType);
    }
}

class Bike extends Vehicle {
    public Bike(String numberPlate, VehicleType vehicleType) {
        super(numberPlate, vehicleType);
    }
}

class Truck extends Vehicle {
    public Truck(String numberPlate, VehicleType vehicleType) {
        super(numberPlate, vehicleType);
    }
}