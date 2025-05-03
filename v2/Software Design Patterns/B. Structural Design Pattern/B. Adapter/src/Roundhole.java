public class Roundhole {
    private double redius;

    public Roundhole(double redius) {
        this.redius = redius;
    }

    public double getRedius() {
        return redius;
    }

    public boolean fits(RoundPeg roundPeg) {
        return this.redius>=roundPeg.getRedius();
    }
}
