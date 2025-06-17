package com.marie.notification.service;

import com.marie.notification.model.NotificationPreference;
import com.marie.notification.model.enums.NotificationTypes;

import java.util.List;

public interface PreferenceService {

    List<NotificationPreference> getPreferencesByCustomerId(Long customerId);

    NotificationPreference addPreference(Long customerId, NotificationTypes type);

    void removePreference(Long preferenceId);

    void updatePreference(Long preferenceId, NotificationTypes newType);
}
