package ro.msg.learning.shop.controller;

import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.model.ProductOrder;
import ro.msg.learning.shop.payroll.ProductOrderNotFoundException;
import ro.msg.learning.shop.repository.IProductOrderRepository;


import java.util.List;

@RestController
public class ProductOrderController {
    private final IProductOrderRepository repository;

    ProductOrderController(IProductOrderRepository repository){
        this.repository=repository;
    }

    @GetMapping("/productOrders")
    List<ProductOrder> all() {
        return repository.findAll();
    }

    @PostMapping("/productOrders")
    ProductOrder newProductOredr(@RequestBody ProductOrder newProductOrder) {
        return repository.save(newProductOrder);
    }

    @GetMapping("/productOrders/{id}")
    ProductOrder one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new ProductOrderNotFoundException(id));
    }

    @PutMapping("/productOrders/{id}")
    ProductOrder updateProductOrder(@RequestBody ProductOrder newProductOrder, @PathVariable Integer id) {

        return repository.findById(id)
                .map(productOrder -> {
                    productOrder.setShippedFrom(newProductOrder.getShippedFrom());
                    return repository.save(newProductOrder);
                })
                .orElseGet(() -> {
                    newProductOrder.setId(id);
                    return repository.save(newProductOrder);
                });
    }

    @DeleteMapping("/productOrders/{id}")
    void deleteProductOrder(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
