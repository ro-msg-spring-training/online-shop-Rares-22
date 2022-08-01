package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.exception.ProductNotFoundException;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.IProductRepository;
import ro.msg.learning.shop.service.ProductService;

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
    // end::get-aggregate-root[]

    @PostMapping("/products")
    Product NewProduct(@RequestBody Product newProduct) {
        return product.save(newProduct);
    }

    // Single item

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
