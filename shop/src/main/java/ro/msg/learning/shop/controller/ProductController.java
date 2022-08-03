package ro.msg.learning.shop.controller;

import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.IProductService;

import java.util.List;

@RestController
public class ProductController {

    private final IProductService productService;

    ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    List<Product> all() {
        return productService.getProducts();
    }


    @PostMapping("/products")
    Product NewProduct(@RequestBody Product newProduct) {
        return productService.createProduct(newProduct);
    }


    @GetMapping("/products/{id}")
    Product one(@PathVariable Integer id) {

        return productService.findById(id);
    }



    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
}
