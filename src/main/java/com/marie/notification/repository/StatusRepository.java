package com.marie.notification.repository;

import com.marie.notification.model.NotificationStatus;
import com.marie.notification.model.enums.NotificationTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StatusRepository extends JpaRepository<NotificationStatus, Long> {

    List<NotificationStatus> findByCustomerId(Long customerId);

    List<NotificationStatus> findByTracker (NotificationTracker tracker);
}
