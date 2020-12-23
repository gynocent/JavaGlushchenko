package bouquet.exception;

public class NotEnoughPriceException extends RuntimeException {
    public NotEnoughPriceException(String message) {
        super(message);
    }
}
