package com.marie.notification.mapper;


import com.marie.notification.dto.PreferenceDTO;
import com.marie.notification.model.NotificationPreference;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PreferenceDTOMapper implements Function<NotificationPreference, PreferenceDTO> {

    @Override
    public PreferenceDTO apply(NotificationPreference notificationPreference) {
        return PreferenceDTO.builder()
                .id(notificationPreference.getId())
                .notificationTypes(notificationPreference.getNotificationTypes())
                .customerId(notificationPreference.getCustomer().getId())
                .build();
    }
}
