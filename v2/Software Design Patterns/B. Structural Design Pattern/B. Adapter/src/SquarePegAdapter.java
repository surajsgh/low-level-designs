public class SquarePegAdapter extends RoundPeg {
    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRedius() {
        return Math.sqrt(Math.pow(this.squarePeg.getWidth()/2, 2)*2);
    }
}
