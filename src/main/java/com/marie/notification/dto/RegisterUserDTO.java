package com.marie.notification.dto;


import com.marie.notification.model.enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserDTO {
    private Long id;

    @NotBlank(message = "FirstName is required")
    private String firstName;

    @NotBlank(message = "LastName is required")
    private String lastName;

    @Email(message = "Please write correct email address")
    @NotBlank(message = "Email address is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;

    @NotNull(message = "Role is required")
    private Roles roles;



}
