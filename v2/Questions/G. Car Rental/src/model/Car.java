package model;

import enums.CarCategory;

public class Car {
    private String id;
    private String make;
    private String model;
    private int year;
    private String vehicleNumber;
    private double rentalPrice;
    private CarCategory carCategory;
    private boolean isAvailable;

    public Car(String id, String make, String model, int year, String vehicleNumber, double rentalPrice, CarCategory carCategory) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.vehicleNumber = vehicleNumber;
        this.rentalPrice = rentalPrice;
        this.carCategory = carCategory;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public CarCategory getCarCategory() {
        return carCategory;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", carCategory=" + carCategory +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
