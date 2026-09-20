package exception;

public class OrderNotFulfillableException extends RuntimeException{
    public OrderNotFulfillableException(String message) {
        super(message);
    }
}
