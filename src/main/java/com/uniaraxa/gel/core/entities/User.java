package com.uniaraxa.gel.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "userId")
@Entity(name = "users")
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(nullable = false)
    private String userName;

    @Column(length = 11)
    private Integer userRa;

    @Column(nullable = false, unique = true, length = 11)
    private long userCpf;

    @Column(unique = true)
    private String userEmail;

    @Column(nullable = false, unique = true, length = 20)
    private String userPhone;

    @Column(nullable = false, length = 20)
    private String userBirthdate;

    @JsonIgnore
    @Column(nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Roles userRole;

    @CreationTimestamp
    private Instant creationDate;

    @UpdateTimestamp
    private Instant updateDate;

    public User(String userName, long userCpf, String userEmail,
                String userPhone, String userBirthdate, Roles userRole,
                String userPassword){
        this.userName = userName;
        this.userCpf = userCpf;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userBirthdate = userBirthdate;
        this.userRole = userRole;
        this.userPassword = userPassword;
    }
}
