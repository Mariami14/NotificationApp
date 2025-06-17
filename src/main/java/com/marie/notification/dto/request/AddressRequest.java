package com.marie.notification.dto.request;

import com.marie.notification.model.enums.AddressType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    @NotNull(message = "Address type is required")
    private AddressType addressType;

    @NotBlank(message = "Value is required")
    private String value;

    @NotNull
    private Boolean isPrimary = false;

    private Boolean isActive = true;
}
