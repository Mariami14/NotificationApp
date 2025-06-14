package com.marie.notification.service;

import com.marie.notification.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void saveCustomer (Customer customer);

}
