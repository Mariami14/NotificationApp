package com.marie.notification.service.implementations;

import com.marie.notification.model.SysUser;
import com.marie.notification.repository.SysUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SysUserServiceImpl implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "User with email %s not found";

    private final SysUserRepository sysUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser u = sysUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MSG, username)));
        return User.withUsername(u.getUsername())
                .password(u.getPassword())
                .roles(u.getRoles().name())
                .build();
    }


}
