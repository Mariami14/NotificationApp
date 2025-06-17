package com.marie.notification.repository;

import com.marie.notification.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface AddressRepository extends JpaRepository <Address, Long> {

    List<Address> findByCustomerId(Long customerId);

    void deleteByCustomerId(Long customerId);

}
