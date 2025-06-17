package com.marie.notification.service.implementations;


import com.marie.notification.model.Customer;
import com.marie.notification.model.NotificationStatus;
import com.marie.notification.repository.CustomerRepository;
import com.marie.notification.repository.StatusRepository;
import com.marie.notification.service.StatusService;
import com.marie.notification.model.enums.AddressType;
import com.marie.notification.model.enums.NotificationTracker;
import com.marie.notification.model.enums.NotificationTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StatusServiceImpl implements StatusService {

    private final CustomerRepository customerRepository;
    private final StatusRepository statusRepository;

    @Override
    public List<NotificationStatus> getStatusByCustomerId(Long customerId) {
        return statusRepository.findByCustomerId(customerId);
    }

    @Override
    public List<NotificationStatus> getStatusByTrack(NotificationTracker track) {
        return statusRepository.findByTracker(track);
    }

    @Override
    public NotificationStatus addStatus(Long customerId, AddressType addressType, NotificationTracker track, NotificationTypes type) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        NotificationStatus status = NotificationStatus.builder()
                .customer(customer)
                .addressType(addressType)
                .tracker(track)
                .notificationTypes(type)
                .build();

        return statusRepository.save(status);
    }

    @Override
    public void updateStatus(Long statusId, NotificationTracker newTracker) {
        NotificationStatus status = statusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Status Not Found"));

        status.setTracker(newTracker);
        statusRepository.save(status);
    }

    @Override
    public void deleteStatus(Long statusId) {
        statusRepository.deleteById(statusId);
    }
}
