package ro.msg.learning.shop.controller;

import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.service.ICustomerService;
import java.util.List;

@RestController
public class CustomerController {
    private final ICustomerService customerService;

    CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    List<Customer> all() {
        return customerService.findAll();
    }

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return customerService.saveCustomer(newCustomer);
    }

    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Integer id) {

        return customerService.findById(id);
    }


}
