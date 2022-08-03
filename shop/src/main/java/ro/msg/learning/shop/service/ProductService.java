package ro.msg.learning.shop.service;


import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exception.CustomerNotFoundException;
import ro.msg.learning.shop.exception.ProductNotFoundException;
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.IProductRepository;
import java.util.Collection;
import java.util.List;

@Service
public class ProductService implements IProductService{

    private final IProductRepository productRepository;

    ProductService(IProductRepository product){
        this.productRepository=product;
    }

    @Override
    public Product createProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }
    @Override
    public Product updateProduct(Integer id, Product newProduct) {
        return productRepository.save(newProduct);
    }
    @Override
    public Product deleteProduct(Integer id) {
        Product p = productRepository.getReferenceById(id);
        productRepository.deleteById(id);
        return p;
    }
    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
