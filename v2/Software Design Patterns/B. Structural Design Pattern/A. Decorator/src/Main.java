//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Milk(new Sugar(new WhippedCream(new BasicCoffee())));
        System.out.println(coffee.getDescription());
        System.out.println("Total Cost: " + coffee.cost());
    }
}