package ro.msg.learning.shop.payroll;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Integer id) {
        super("Could not find product" + id);
    }
}
