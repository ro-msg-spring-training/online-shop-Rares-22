package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exception.CustomerNotFoundException;
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.repository.ICustomerRepository;
import java.util.List;


@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);

    }

    public void deleteAll() {
        customerRepository.deleteAll();
    }

}
