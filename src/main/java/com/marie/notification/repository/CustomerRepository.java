package com.marie.notification.repository;

import com.marie.notification.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customers WHERE " +
            "(:firstName IS NULL OR LOWER(first_name) LIKE LOWER(CONCAT('%', :firstName, '%'))) " +
            "OR (:lastName IS NULL OR LOWER(last_name) LIKE LOWER(CONCAT('%', :lastName, '%')))",
            nativeQuery = true)
    List<Customer> searchByName(@Param("firstName") String firstName,
                                @Param("lastName") String lastName);


    List<Customer> getCustomerById(Long customerId);

}
