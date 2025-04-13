public class Director {
    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS);
        builder.setEngine(new Engine(3.0, 10));
        builder.setGPSNavigator(new GPSNavigator("Mumbai"));
        builder.setsSeats(2);
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setEngine(new Engine(3.0, 20));
        builder.setGPSNavigator(new GPSNavigator("Bengaluru"));
        builder.setsSeats(4);
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
    }
}
