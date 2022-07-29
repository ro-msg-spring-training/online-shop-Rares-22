package ro.msg.learning.shop.service;

import ro.msg.learning.shop.model.Product;

import java.util.Collection;

public interface IProductService {
     void createProduct(Product product);
     void updateProduct(Integer id, Product product);
     void deleteProduct(Integer id);
     Collection<Product> getProducts();
}
