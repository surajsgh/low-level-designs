public class TripComputer {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void getFuel() {
        System.out.println("Total fuel: " + this.car.getFuel());
    }

    public void showStatus() {
        if (car.getEngine().getStarted()) {
            System.out.println("Car has started!");
        }
        else {
            System.out.println("Car isn't started.");
        }
    }
}
