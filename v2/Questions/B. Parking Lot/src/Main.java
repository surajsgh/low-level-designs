import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<ParkingSpot> parkingSpots1 = List.of(
                new ParkingSpot(false, null, VehicleType.CAR),
                new ParkingSpot(false, null, VehicleType.BIKE)
        );
        List<ParkingSpot> parkingSpots2 = List.of(
                new ParkingSpot(false, null, VehicleType.CAR),
                new ParkingSpot(false, null, VehicleType.TRUCK)
        );
        Level level1 = new Level(parkingSpots1);
        Level level2 = new Level(parkingSpots2);




        ParkingLot parkingLot = new ParkingLot(List.of(level1, level2));
        System.out.println("Total free spots at all levels: " + parkingLot.totalAvailableFreeSpots());
        System.out.println("Total free spots at level 1: " + parkingLot.getAvailableFreeSpots(1));
        System.out.println("Total free spots at level 2: " + parkingLot.getAvailableFreeSpots(2));

        Runnable thread1 = () -> {
            Vehicle bike = new Bike("123", VehicleType.BIKE);
            ParkingSpot parkingSpotForBike = parkingLot.park(1, bike);
        };

        Runnable thread2 = () -> {
            Vehicle car = new Car("111", VehicleType.CAR);
            ParkingSpot parkingSpotForCar = parkingLot.park(1, car);
        };

        Thread first = new Thread(thread1);
        Thread second = new Thread(thread2);

        first.start();
        first.join();
        second.start();
        second.join();

        System.out.println("Total free spots at all levels: " + parkingLot.totalAvailableFreeSpots());
        System.out.println("Total free spots at level 1: " + parkingLot.getAvailableFreeSpots(1));
        System.out.println("Total free spots at level 2: " + parkingLot.getAvailableFreeSpots(2));

        /*
        try {
            parkingLot.release(-2, parkingSpotForBike);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Total free spots at all levels: " + parkingLot.totalAvailableFreeSpots());
        System.out.println("Total free spots at level 1: " + parkingLot.getAvailableFreeSpots(1));
        System.out.println("Total free spots at level 2: " + parkingLot.getAvailableFreeSpots(2));
         */
    }
}