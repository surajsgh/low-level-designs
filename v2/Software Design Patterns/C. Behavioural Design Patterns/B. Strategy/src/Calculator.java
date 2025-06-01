public class Calculator {
    ArithmeticOperation arithmeticOperation;

    public Calculator(ArithmeticOperation arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
    }

    public double calculate(int a, int b) {
        return arithmeticOperation.execute(a, b);
    }
}
