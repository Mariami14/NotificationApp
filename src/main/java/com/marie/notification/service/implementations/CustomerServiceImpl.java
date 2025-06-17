package com.marie.notification.service.implementations;

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
        return customerRepository.searchByName(firstName, lastName);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found id=" + id));
    }
}
