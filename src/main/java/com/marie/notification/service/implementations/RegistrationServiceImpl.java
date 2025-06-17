package com.marie.notification.service.implementations;

import com.marie.notification.dto.RegisterUserDTO;
import com.marie.notification.model.SysUser;
import com.marie.notification.model.enums.Roles;
import com.marie.notification.repository.SysUserRepository;
import com.marie.notification.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationServiceImpl  implements RegistrationService {

    private final SysUserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterUserDTO dto) {
        Roles role = (dto.getRoles() != null) ? dto.getRoles() : Roles.ADMIN;

        SysUser user = SysUser.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(role)
                .build();

        userRepo.save(user);
    }
}
