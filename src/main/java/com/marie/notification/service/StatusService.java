package com.marie.notification.service;

import com.marie.notification.model.NotificationStatus;
import com.marie.notification.model.enums.AddressType;
import com.marie.notification.model.enums.NotificationTracker;
import com.marie.notification.model.enums.NotificationTypes;

import java.util.List;

public interface StatusService {

    List<NotificationStatus> getStatusByCustomerId(Long customerId);

    List<NotificationStatus> getStatusByTrack(NotificationTracker track);

    NotificationStatus addStatus(Long customerId, AddressType addressType, NotificationTracker track, NotificationTypes type);

    void updateStatus(Long statusId, NotificationTracker newTrack);

    void deleteStatus(Long statusId);
}
