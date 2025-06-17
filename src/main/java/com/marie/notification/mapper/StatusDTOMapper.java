package com.marie.notification.mapper;


import com.marie.notification.dto.StatusDTO;
import com.marie.notification.model.NotificationStatus;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StatusDTOMapper implements Function<NotificationStatus, StatusDTO> {

    @Override
    public StatusDTO apply(NotificationStatus notificationStatus) {
        return StatusDTO.builder()
                .id(notificationStatus.getId())
                .addressType(notificationStatus.getAddressType())
                .notificationTypes(notificationStatus.getNotificationTypes())
                .notificationTracker(notificationStatus.getTracker())
                .customerId(notificationStatus.getCustomer().getId())
                .build();
    }
}
