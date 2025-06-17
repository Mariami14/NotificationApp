package com.marie.notification.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    @NotBlank(message = "Firstname is required")
    private String firstName;

    @NotBlank(message = "Lastname is required")
    private String lastName;

    @Email(message = "Please provide a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    private String phoneNumber;
    private String postal;
}
