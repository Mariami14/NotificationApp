package com.marie.notification.controller;


import com.marie.notification.dto.AddressDTO;
import com.marie.notification.mapper.AddressDTOMapper;
import com.marie.notification.model.Address;
import com.marie.notification.service.AddressService;
import com.marie.notification.dto.request.AddressRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    private final AddressDTOMapper addressDTOMapper;

    @GetMapping("/form/{customerId}")
    public String showAddressForm(@PathVariable Long customerId, Model model) {
        model.addAttribute("address", new AddressRequest());
        model.addAttribute("customerId", customerId);
        return "address-form";
    }

    @GetMapping("/list/{customerId}")
    public String listCustomerAddresses(@PathVariable Long customerId, Model model) {
        List<AddressDTO> addresses = addressService.getAddressesByCustomerId(customerId)
                .stream()
                .map(addressDTOMapper)
                .toList();
        model.addAttribute("addresses", addresses);
        model.addAttribute("customerId", customerId);
        return "address-list";
    }

    @GetMapping("/add/{customerId}")
    public String showAddAddressForm(@PathVariable Long customerId, Model model) {
        model.addAttribute("address", new AddressRequest());
        model.addAttribute("customerId", customerId);
        return "address-form";
    }

    @PostMapping("/save/{customerId}")
    public String saveAddress(@PathVariable Long customerId,
                              @Valid @ModelAttribute("address") AddressRequest addressRequest,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("customerId", customerId);
            return "address-form";
        }

        Address address = Address.builder()
                .addressType(addressRequest.getAddressType())
                .value(addressRequest.getValue())
                .isPrimary(addressRequest.getIsPrimary())
                .isActive(addressRequest.getIsActive())
                .build();

        addressService.addAddress(address, customerId);
        return "redirect:/address/list/" + customerId;
    }

    @PostMapping("/update/{id}/{customerId}")
    public String updateAddressHtml(@PathVariable Long id,
                                    @PathVariable Long customerId,
                                    @Valid @ModelAttribute("address") AddressRequest req,
                                    BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            model.addAttribute("customerId", customerId);
            return "address-form";
        }

        Address toSave = Address.builder()
                .addressType(req.getAddressType())
                .value(req.getValue())
                .isPrimary(req.getIsPrimary())
                .isActive(req.getIsActive())
                .build();

        addressService.updateAddress(id, toSave);

        return "redirect:/address/list/" + customerId;
    }

    @GetMapping("/delete/{id}/{customerId}")
    public String deleteAddress(@PathVariable Long id,
                                @PathVariable Long customerId) {
        addressService.deleteAddress(id);
        return "redirect:/address/list/" + customerId;
    }
}
