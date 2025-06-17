package com.marie.notification.dto;


import com.marie.notification.model.enums.AddressType;
import com.marie.notification.model.enums.NotificationTracker;
import com.marie.notification.model.enums.NotificationTypes;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusDTO {


    private Long id;
    private Long customerId;

    @NotNull(message = "Required field")
    private AddressType addressType;

    @NotNull(message = "Required field")
    private NotificationTracker notificationTracker;

    @NotNull(message = "Required field")
    private NotificationTypes notificationTypes;
}
