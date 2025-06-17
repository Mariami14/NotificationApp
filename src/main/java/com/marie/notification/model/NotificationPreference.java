package com.marie.notification.model;


import com.marie.notification.model.enums.NotificationTypes;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table (name = "notificationPreference")
public class NotificationPreference {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @Enumerated (EnumType.STRING)
    private NotificationTypes notificationTypes;
}
