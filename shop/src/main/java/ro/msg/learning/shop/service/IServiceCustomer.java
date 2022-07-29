package ro.msg.learning.shop.service;

import ro.msg.learning.shop.model.Customer;

import java.util.Collection;

public interface IServiceCustomer {

    public abstract void newCustomer(Customer customer);
    public abstract void updateCustomer(String id, Customer customer);
    public abstract void deleteCustomer(String id);
    public abstract Collection<Customer> getCustomer();
}
