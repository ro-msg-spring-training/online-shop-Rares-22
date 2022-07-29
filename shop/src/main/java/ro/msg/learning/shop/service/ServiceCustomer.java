package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.repository.ICustomerRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceCustomer implements IServiceCustomer {
    private static Map<String, Customer> customerRepo = new HashMap<>();
    @Override
    public void newCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(String id, Customer customer) {

    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public Collection<Customer> getCustomer() {
        return null;
    }
}
