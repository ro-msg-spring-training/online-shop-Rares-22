package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTO.ProductCategoryDTO;
import ro.msg.learning.shop.model.Category;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.IProductRepository;

import java.util.Collection;

@Service
public class ProductService implements IProductService{

    private final IProductRepository product;

    ProductService(IProductRepository product){
        this.product=product;
    }

    @Override
    public void createProduct(Product newProduct) {
        product.save(newProduct);
    }
    @Override
    public void updateProduct(Integer id, Product newProduct) {
        product.save(newProduct);
    }
    @Override
    public void deleteProduct(Integer id) {
        product.deleteById(id);

    }
    @Override
    public Collection<Product> getProducts() {
        return product.findAll();
    }
}
