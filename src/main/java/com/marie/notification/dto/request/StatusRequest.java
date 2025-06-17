package com.marie.notification.dto.request;

import com.marie.notification.model.enums.AddressType;
import com.marie.notification.model.enums.NotificationTracker;
import com.marie.notification.model.enums.NotificationTypes;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StatusRequest {
    @NotNull
    private Long customerId;
    @NotNull
    private AddressType addressType;
    @NotNull
    private NotificationTracker notificationTracker;
    @NotNull
    private NotificationTypes notificationTypes;
}
