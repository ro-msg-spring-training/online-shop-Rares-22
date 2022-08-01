package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.ProductOrder;
import ro.msg.learning.shop.repository.IProductOrderRepository;

import java.util.Collection;

@Service
public class OrderService implements IOrderService{
    private final IProductOrderRepository order;

    OrderService(IProductOrderRepository order){
        this.order=order;
    }

    @Override
    public void createProductOrder(ProductOrder newProductOrder) {
        order.save(newProductOrder);
    }
    @Override
    public void updateProductOrder(Integer id, ProductOrder newProductOrder) {
        order.save(newProductOrder);
    }
    @Override
    public void deleteProductOrder(Integer id) {
        order.deleteById(id);

    }
    @Override
    public Collection<ProductOrder> getProductOrders() {
        return order.findAll();
    }
}
