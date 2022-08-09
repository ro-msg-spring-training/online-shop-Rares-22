package ro.msg.learning.shop.service;

import ro.msg.learning.shop.model.Customer;
import java.util.List;

public interface ICustomerService {

     List<Customer> findAll();
     Customer findById(Integer id);
     Customer saveCustomer(Customer customer);
     void deleteAll();
}
