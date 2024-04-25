abstract class BasePizza {
    public abstract int cost();
}

class VegPizza extends BasePizza {
    @Override
    public int cost() {
        return 100;
    }
}

class ChickenPizza extends BasePizza {
    @Override
    public int cost() {
        return 120;
    }
}

abstract class Toppings extends BasePizza {

}

class Mushrooms extends Toppings {
    BasePizza basePizza;

    public Mushrooms(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 25;
    }
}

class Capsicum extends Toppings {
    BasePizza basePizza;

    public Capsicum(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 30;
    }
}

class Paneer extends Toppings {
    BasePizza basePizza;

    public Paneer(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 40;
    }
}

public class Main {
    public static void main(String[] args) {
        BasePizza basePizza = new Paneer(new Capsicum(new ChickenPizza()));
        System.out.println(basePizza.cost());
    }
}