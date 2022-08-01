package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exception.CustomerNotFoundException;
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.repository.ICustomerRepository;


@Service
public class CustomerService {
    private final ICustomerRepository customerRepository;

    CustomerService(ICustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


    public Customer findById (Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }
    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteAll(){
        customerRepository.deleteAll();
    }

}
