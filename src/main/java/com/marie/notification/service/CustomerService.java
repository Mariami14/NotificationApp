package com.marie.notification.service;

import com.marie.notification.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id);

    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);

    void deleteCustomer(Long id);

    Customer updateCustomer(Long id, Customer customer);

    List<Customer> search(String firstName, String lastName);


}
