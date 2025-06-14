package com.marie.notification.controller;

import com.marie.notification.model.Customer;
import com.marie.notification.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String viewHomePage (Model model){
        model.addAttribute("customersList", customerService.getAllCustomers());
        return "index";
    }
    //todo method handler which handels new employee request form
    @GetMapping("/showCustomerForm")
    public String showCustomerForm (Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "newCustomer";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer (@ModelAttribute("customer")Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/api/customer/"; //todo redirection aketebs @GetMapping("/") am gverdze
    }
}
