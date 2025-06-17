package com.marie.notification.mapper;


import com.marie.notification.dto.RegisterUserDTO;
import com.marie.notification.model.SysUser;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RegisterUserDTOMapper implements Function<SysUser, RegisterUserDTO> {
    @Override
    public RegisterUserDTO apply(SysUser sysUser) {
        return RegisterUserDTO.builder()
                .id(sysUser.getId())
                .firstName(sysUser.getFirstName())
                .lastName(sysUser.getLastName())
                .username(sysUser.getUsername())
                .password(sysUser.getPassword())
                .roles(sysUser.getRoles())
                .build();
    }
}
