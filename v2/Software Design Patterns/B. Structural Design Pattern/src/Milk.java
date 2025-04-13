public class Milk extends CoffeDecorator{
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public int cost() {
        return super.cost() + 5;
    }
}
