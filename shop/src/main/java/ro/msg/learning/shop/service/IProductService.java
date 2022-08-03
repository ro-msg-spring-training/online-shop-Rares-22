package ro.msg.learning.shop.service;

import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.model.Product;
import java.util.Collection;
import java.util.List;

public interface IProductService {
     Product createProduct(Product product);
     Product updateProduct(Integer id, Product product);
     Product deleteProduct(Integer id);

     Product findById(Integer id);
     List<Product> getProducts();
}
