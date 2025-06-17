package com.marie.notification.controller;

import com.marie.notification.dto.RegisterUserDTO;
import com.marie.notification.model.SysUser;
import com.marie.notification.model.enums.Roles;
import com.marie.notification.repository.SysUserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class RegisterUserController {

    private final SysUserRepository sysUserRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String registrationForm(Model model) {
        model.addAttribute("registerUserDTO", new RegisterUserDTO());
        return "registration";
    }

    @PostMapping
    public String registerUser(
            @Valid @ModelAttribute("registerUserDTO") RegisterUserDTO registerUserDTO,
            BindingResult bindingResult,
            Model model) {

        if (!registerUserDTO.getPassword().equals(registerUserDTO.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "Passwords do not match");
        }

        if (sysUserRepository.findByUsername(registerUserDTO.getUsername()).isPresent()) {
            bindingResult.rejectValue("username", "error.username", "Username already taken");
        }

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        SysUser sysUser = SysUser.builder()
                .firstName(registerUserDTO.getFirstName())
                .lastName(registerUserDTO.getLastName())
                .username(registerUserDTO.getUsername())
                .password(passwordEncoder.encode(registerUserDTO.getPassword()))
                .roles(registerUserDTO.getRoles() != null ? registerUserDTO.getRoles() : Roles.ADMIN)
                .build();

        sysUserRepository.save(sysUser);

        return "redirect:/login";
    }
}



