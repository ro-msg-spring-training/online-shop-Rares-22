package ro.msg.learning.shop.controller;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.exception.ProductNotFoundException;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.IProductRepository;


import java.util.List;

@RestController
public class ProductController {

    private final IProductRepository product;

    ProductController(IProductRepository product) {
        this.product = product;
    }

    @GetMapping("/products")
    List<Product> all() {
        return product.findAll();
    }


    @PostMapping("/products")
    Product NewProduct(@RequestBody Product newProduct) {
        return product.save(newProduct);
    }


    @GetMapping("/products/{id}")
    Product one(@PathVariable Integer id) {

        return product.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }


    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Integer id) {
        product.deleteById(id);
    }
}
