package com.marie.notification.controller;

import com.marie.notification.dto.CustomerDTO;
import com.marie.notification.mapper.CustomerDTOMapper;
import com.marie.notification.model.Customer;
import com.marie.notification.service.CustomerService;
import com.marie.notification.dto.request.CustomerRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerService customerService;
    private final CustomerDTOMapper customerDTOMapper;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<CustomerDTO> customersList = customerService.getAllCustomers()
                .stream()
                .map(customerDTOMapper)
                .toList();
        model.addAttribute("customersList", customersList);
        return "customer-list";
    }


    @GetMapping("/showCustomerForm")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new CustomerRequest());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerRequest customerRequest,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "customer-form";
        }
        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .phoneNumber(customerRequest.getPhoneNumber())
                .email(customerRequest.getEmail())
                .postal(customerRequest.getPostal())
                .build();
        customerService.addCustomer(customer);
        return "redirect:/api/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/api/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.getById(id);
        if (customer == null) {
            return "redirect:/api/customer/list";
        }
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setFirstName(customer.getFirstName());
        customerRequest.setLastName(customer.getLastName());
        customerRequest.setEmail(customer.getEmail());
        customerRequest.setPhoneNumber(customer.getPhoneNumber());
        customerRequest.setPostal(customer.getPostal());

        model.addAttribute("customer", customerRequest);
        return "customer-form";
    }
}
