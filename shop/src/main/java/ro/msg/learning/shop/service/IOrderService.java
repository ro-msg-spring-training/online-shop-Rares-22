package ro.msg.learning.shop.service;

import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.ProductOrder;

import java.util.Collection;

public interface IOrderService {

    void createProductOrder(ProductOrder order);
    void updateProductOrder(Integer id, ProductOrder order);
    void deleteProductOrder(Integer id);
    Collection<ProductOrder> getProductOrders();
}
