interface Car {
    void drive();
}

interface MotorCycle {
    void drive();
}

class ElectricCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving electric car...");
    }
}

class GasolineCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving gasoline car...");
    }
}

class ElectricMotorCycle implements MotorCycle {
    @Override
    public void drive() {
        System.out.println("Driving electric motor-cycle...");
    }
}

class GasolineMotorCycle implements MotorCycle {
    @Override
    public void drive() {
        System.out.println("Driving gasoline motor-cycle...");
    }
}

interface VehicleFactory {
    Car createCar();
    MotorCycle createMotorCycle();
}

class ElectricVehicleFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new ElectricCar();
    }

    @Override
    public MotorCycle createMotorCycle() {
        return new ElectricMotorCycle();
    }
}

class GasolineVehicleFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new GasolineCar();
    }

    @Override
    public MotorCycle createMotorCycle() {
        return new GasolineMotorCycle();
    }
}

class VehicleApplication {
    private Car car;
    private MotorCycle motorCycle;

    public VehicleApplication(VehicleFactory vehicleFactory) {
        this.car = vehicleFactory.createCar();
        this.motorCycle = vehicleFactory.createMotorCycle();
    }

    public void testDrive() {
        car.drive();
        motorCycle.drive();
    }
}

public class Main {
    public static void main(String[] args) {
        VehicleFactory electricVehicleFactory = new ElectricVehicleFactory();
        VehicleFactory gasolineVehicleFactory = new GasolineVehicleFactory();

        VehicleApplication vehicleApplication = new VehicleApplication(electricVehicleFactory);
        vehicleApplication.testDrive();
    }
}