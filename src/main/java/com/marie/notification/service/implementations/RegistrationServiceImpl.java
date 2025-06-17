package com.marie.notification.service.implementations;

import com.marie.notification.dto.RegisterUserDTO;
import com.marie.notification.model.SysUser;
import com.marie.notification.repository.SysUserRepository;
import com.marie.notification.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl  implements RegistrationService {

    private final SysUserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterUserDTO dto) {
        SysUser user = SysUser.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(dto.getRoles())
                .build();

        userRepo.save(user);
    }
}
