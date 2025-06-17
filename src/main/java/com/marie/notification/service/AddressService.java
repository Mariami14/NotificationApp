package com.marie.notification.service;


import com.marie.notification.model.Address;

import java.util.List;

public interface AddressService {

    Address addAddress(Address address, Long customerId);

    Address updateAddress(Long addressId, Address updatedAddress);

    void deleteAddress(Long addressId);

    List<Address> getAddressesByCustomerId(Long customerId);

    void deleteAllByCustomerId(Long customerId);

}
