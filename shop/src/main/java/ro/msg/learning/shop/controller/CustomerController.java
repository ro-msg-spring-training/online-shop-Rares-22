package ro.msg.learning.shop.controller;

import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.payroll.CustomerNotFoundException;
import ro.msg.learning.shop.repository.ICustomerRepository;

import java.util.List;

@RestController
public class CustomerController {
    private final ICustomerRepository repository;

    CustomerController(ICustomerRepository repository){
        this.repository=repository;
    }

    @GetMapping("/customers")
    List<Customer> all() {
        return repository.findAll();
    }

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customer/{id}")
    Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable Integer id) {

        return repository.findById(id)
                .map(customer -> {
                    customer.setFirst_name(newCustomer.getFirst_name());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }

    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
