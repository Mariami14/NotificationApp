package com.marie.notification.model;

import com.marie.notification.util.AddressType;
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
 private Boolean isPrimary; // tu orive miutita mag shemtxvevashi
 private Boolean isActive; // araaqtiuri misamartebi unda wavshalot

 //will be handled by db
 /*@CreationTimestamp
 private LocalDateTime createdAt;
 @UpdateTimestamp
 private LocalDateTime updatedAt;*/

 @Column(name = "created_at", updatable = false, insertable = false)
 private LocalDateTime createdAt;

 @Column(name = "updated_at", insertable = false)
 private LocalDateTime updatedAt;


@ManyToOne
@JoinColumn(name = "customer_id", referencedColumnName = "id")
private Customer customer;


 @Enumerated(EnumType.STRING)
 private AddressType addressType;

}
