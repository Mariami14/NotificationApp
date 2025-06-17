package com.marie.notification.mapper;

import com.marie.notification.dto.CustomerDTO;
import com.marie.notification.model.Customer;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {
    @Override
    public CustomerDTO apply(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phoneNumber(customer.getPhoneNumber())
                .email(customer.getEmail())
                .postal(customer.getPostal())
                .createdAt(customer.getCreatedAt())
                .updatedAt(customer.getUpdatedAt())
                .build();
    }
}
