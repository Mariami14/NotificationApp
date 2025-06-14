package com.marie.notification.model;

import com.marie.notification.util.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder //todo es ristvisaa
@Table(name = "Administrators DB")
public class Admin {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName; // todo unda iyos email rac ginda is daarqvi
    private String password;
    /*@CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;*/

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;




    //todo ra gansxvavebaa enum tipebshi? - უსაფრთხოებისთვის გვინდა ეს, სამომავლოდ იქნებ მომინდეს როლების დამატება
    @Enumerated (EnumType.STRING)
    private Roles roles;

    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    // todo id gareshe konstruktori radgan davagenerirebt avtomaturad
    //todo konstruktorebi + id gareshe konstruktori dasamatebeli
    // todo getter da setter dasamatebeli
    // todo tostring aucileblad


    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", roles=" + roles +
                '}';
    }
}
