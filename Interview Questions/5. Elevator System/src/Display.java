public class Display {
    int floor;
    Direction direction;

    public Display(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Display{" +
                "floor=" + floor +
                ", direction=" + direction +
                '}';
    }
}
