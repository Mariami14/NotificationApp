package com.marie.notification.service.implementations;


import com.marie.notification.model.Address;
import com.marie.notification.model.Customer;
import com.marie.notification.repository.AddressRepository;
import com.marie.notification.repository.CustomerRepository;
import com.marie.notification.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    public AddressServiceImpl(AddressRepository addressRepository, CustomerRepository customerRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Address addAddress(Address address, Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));
        address.setCustomer(customer);
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long addressId, Address updatedAddress) {
        return addressRepository.findById(addressId).map(address -> {
            address.setAddressType(updatedAddress.getAddressType());
            address.setValue(updatedAddress.getValue());
            address.setIsActive(updatedAddress.getIsActive());
            return addressRepository.save(address);
        }).orElseThrow(() -> new RuntimeException("Address Not Found"));
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public List<Address> getAddressesByCustomerId(Long customerId) {
        return addressRepository.findByCustomerId(customerId);
    }

    @Override
    public void deleteAllByCustomerId(Long customerId) {
        addressRepository.deleteByCustomerId(customerId);
    }
}
