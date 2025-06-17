package com.marie.notification.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "Firstname is required")
    private String firstName;

    @NotBlank(message = "Lastname is required")
    private String lastName;

    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Incorrect phone number format")
    private String phoneNumber;

    @Email(message = "Incorrect email format")
    private String email;

    private String postal;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
