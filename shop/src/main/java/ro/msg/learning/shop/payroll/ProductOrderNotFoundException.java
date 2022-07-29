package ro.msg.learning.shop.payroll;

public class ProductOrderNotFoundException extends RuntimeException {
    public ProductOrderNotFoundException(Integer id) {
        super("Product order not found" + id);
    }
}
