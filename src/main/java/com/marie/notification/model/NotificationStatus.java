package com.marie.notification.model;

import com.marie.notification.util.AddressType;
import com.marie.notification.util.NotificationTrack;
import com.marie.notification.util.NotificationTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table (name = "notificationStatus")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationStatus {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;


    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @Enumerated
    private AddressType addressType;

    @Enumerated
    private NotificationTrack notificationTrack;

    @Enumerated
    private NotificationTypes notificationTypes;
}
