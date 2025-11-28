package com.uniaraxa.gel.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "userID")
@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userID;

    @Column(nullable = false)
    private String userName;

    @Column(unique = true, length = 11)
    private int userRA;

    @Column(nullable = false, unique = true, length = 11)
    private int userCPF;

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
}
