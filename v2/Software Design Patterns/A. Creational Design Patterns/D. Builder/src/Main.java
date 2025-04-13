public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();
        director.constructCityCar(carBuilder);
        Car car = carBuilder.getResult();
        System.out.println("Car Type: " + car.getCarType());

        CarManualBuilder carManualBuilder = new CarManualBuilder();
        director.constructCityCar(carManualBuilder);
        CarManual carManual = carManualBuilder.getManual();
        System.out.println("Car information: " + carManual.print());
    }
}