package ro.msg.learning.shop.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Integer id) {
        super("Could not find customer " + id);
    }
}
