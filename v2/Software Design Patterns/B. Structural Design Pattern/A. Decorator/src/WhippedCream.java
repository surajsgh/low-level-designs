public class WhippedCream extends CoffeDecorator{
    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whipped cream";
    }

    @Override
    public int cost() {
        return super.cost() + 10;
    }
}
