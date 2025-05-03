public class Sugar extends CoffeDecorator{
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
