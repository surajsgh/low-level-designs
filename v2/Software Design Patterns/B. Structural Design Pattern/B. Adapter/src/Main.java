//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RoundPeg smallRoundPeg = new RoundPeg(2);
        Roundhole roundhole = new Roundhole(2);
        if (roundhole.fits(smallRoundPeg)) {
            System.out.println("smallRoundPeg fits with roundHole");
        }

        SquarePeg smallSquarePeg = new SquarePeg(2);
        SquarePeg bigSquarePeg = new SquarePeg(10);

        SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter bigSquarePegAdapter = new SquarePegAdapter(bigSquarePeg);
        if (roundhole.fits(smallSquarePegAdapter)) {
            System.out.println("smallSquarePeg fits into roundHole.");
        }
        if (roundhole.fits(bigSquarePegAdapter)) {
            System.out.println("bigSquarePeg fits into roundHole.");
        }
    }
}