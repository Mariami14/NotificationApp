package com.marie.notification.repository;


import com.marie.notification.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface SysUserRepository extends JpaRepository <SysUser, Long> {

    Optional<SysUser> findByUsername(String username);

}
