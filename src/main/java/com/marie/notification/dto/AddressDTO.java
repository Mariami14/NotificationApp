package com.marie.notification.dto;


import com.marie.notification.model.enums.AddressType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {

    private Long id;
    private Long customerId;

    @NotBlank(message = "Notification preference is required")
    private String value;

    @NotNull(message = "Required field")
    private Boolean isPrimary;

    private Boolean isActive;

    @NotNull(message = "Required field")
    private AddressType addressType;
}
