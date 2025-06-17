package com.marie.notification.repository;

import com.marie.notification.model.NotificationPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PreferenceRepository extends JpaRepository<NotificationPreference, Long> {
    List<NotificationPreference> findByCustomerId(Long customerId);
}
