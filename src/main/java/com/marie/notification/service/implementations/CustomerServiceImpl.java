package com.marie.notification.service.implementations;

import com.marie.notification.dto.request.CustomerRequest;
import com.marie.notification.model.Customer;
import com.marie.notification.repository.CustomerRepository;
import com.marie.notification.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void addCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Long id, Customer dto) {
        return customerRepository.findById(id)
                .map(existing -> {
                    existing.setFirstName(dto.getFirstName());
                    existing.setLastName(dto.getLastName());
                    existing.setEmail(dto.getEmail());
                    existing.setPhoneNumber(dto.getPhoneNumber());
                    existing.setPostal(dto.getPostal());
                    existing.setPreferences(dto.getPreferences());
                    return customerRepository.save(existing);
                })
                .orElseThrow(() ->
                        new RuntimeException("Customer not found id=" + id));
    }

    @Override
    public List<Customer> search(String firstName, String lastName) {
        return customerRepository
                .findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
                        firstName == null ? "" : firstName,
                        lastName  == null ? "" : lastName);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found id=" + id));
    }
    @Override
    public Customer updateOrCreate(CustomerRequest customerRequest) {

        Customer customer = customerRequest.getId() != null
                ? customerRepository.findById(customerRequest.getId()).orElse(new Customer())
                : new Customer();

        copyFields(customerRequest, customer);
        return customerRepository.save(customer);
    }
    private void copyFields(CustomerRequest customerRequest, Customer customer) {
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setPostal(customerRequest.getPostal());
    }
}
