//  Normal parent-child relationship
//  Here's a duplicate overridden methods in offRoad and advVehicle.
//  In order to avoid that duplication, we'll use strategy pattern.
class Vehicle {
    public void drive() {
        System.out.println("Driving normally...");
    }
}

class SportVehicle extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving sportingly...");
    }
}

class offRoadVehicle extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving off road...");
    }
}

class onRoadVehicle extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving on road...");
    }
}

class advVehicle extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving off road...");
    }
}

interface DriveStrategy {
    public void drive();
}

class OnRoadDrive implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving on road...");
    }
}

class OffRoadDrive implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving off road...");
    }
}

class AnotherVehicle {
    DriveStrategy driveStrategy;

    public AnotherVehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}

class KTM extends AnotherVehicle {
    public KTM() {
        super(new OnRoadDrive());
    }
}

class triumph extends AnotherVehicle {
    public triumph() {
        super(new OffRoadDrive());
    }
}

public class Main {
    public static void main(String[] args) {
        AnotherVehicle bike = new triumph();
        bike.drive();
    }
}