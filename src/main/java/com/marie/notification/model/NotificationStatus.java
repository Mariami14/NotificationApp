package com.marie.notification.model;

import com.marie.notification.model.enums.AddressType;
import com.marie.notification.model.enums.NotificationTracker;
import com.marie.notification.model.enums.NotificationTypes;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table (name = "notificationTracker")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NotificationStatus {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @Enumerated (EnumType.STRING)
    private AddressType addressType;

    @Enumerated (EnumType.STRING)
    private NotificationTracker tracker;

    @Enumerated (EnumType.STRING)
    private NotificationTypes notificationTypes;
}
