package com.marie.notification.service.implementations;


import com.marie.notification.model.Customer;
import com.marie.notification.model.NotificationPreference;
import com.marie.notification.repository.CustomerRepository;
import com.marie.notification.repository.PreferenceRepository;
import com.marie.notification.service.PreferenceService;
import com.marie.notification.model.enums.NotificationTypes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    private final CustomerRepository customerRepository;
    private final PreferenceRepository preferenceRepository;

    public PreferenceServiceImpl(CustomerRepository customerRepository, PreferenceRepository preferenceRepository) {
        this.customerRepository = customerRepository;
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public List<NotificationPreference> getPreferencesByCustomerId(Long customerId) {
        return preferenceRepository.findByCustomerId(customerId);
    }

    @Override
    public NotificationPreference addPreference(Long customerId, NotificationTypes type) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        NotificationPreference preference = NotificationPreference.builder()
                .customer(customer)
                .notificationTypes(type)
                .build();
        return preferenceRepository.save(preference);
    }

    @Override
    public void removePreference(Long preferenceId) {
        preferenceRepository.deleteById(preferenceId);
    }

    @Override
    public void updatePreference(Long preferenceId, NotificationTypes newType) {
        NotificationPreference preference = preferenceRepository.findById(preferenceId)
                .orElseThrow(() -> new RuntimeException("Preference Not Found"));

        preference.setNotificationTypes(newType);
        preferenceRepository.save(preference);
    }
}
