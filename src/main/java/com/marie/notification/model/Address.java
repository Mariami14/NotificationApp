package com.marie.notification.model;

import com.marie.notification.model.enums.AddressType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;



@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address {

 @Id
 @GeneratedValue (strategy = GenerationType.IDENTITY)
 private Long id;
 private String value;     // actual contact like email, phone, or address
 private Boolean isPrimary; //if a few addresses were added
 private Boolean isActive;


 @CreationTimestamp
 private LocalDateTime createdAt;
 @UpdateTimestamp
 private LocalDateTime updatedAt;


@ManyToOne
@JoinColumn(name = "customer_id", referencedColumnName = "id")
private Customer customer;


 @Enumerated(EnumType.STRING)
 private AddressType addressType;

}
