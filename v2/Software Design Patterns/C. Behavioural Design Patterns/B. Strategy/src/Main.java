public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new Addition());
        System.out.println(calculator.calculate(1, 3));
    }
}