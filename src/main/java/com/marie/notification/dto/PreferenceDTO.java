package com.marie.notification.dto;


import com.marie.notification.model.enums.NotificationTypes;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PreferenceDTO {

    private Long id;
    private Long customerId;

    @NotNull(message = "Required field")
    private NotificationTypes notificationTypes;
}
