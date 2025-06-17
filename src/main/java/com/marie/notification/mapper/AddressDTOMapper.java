package com.marie.notification.mapper;


import com.marie.notification.dto.AddressDTO;
import com.marie.notification.model.Address;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AddressDTOMapper implements Function<Address, AddressDTO> {
    @Override
    public AddressDTO apply(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .value(address.getValue())
                .isPrimary(address.getIsPrimary())
                .isActive(address.getIsActive())
                .addressType(address.getAddressType())
                .customerId(address.getCustomer().getId())
                .build();
    }
}
