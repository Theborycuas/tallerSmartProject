package com.codesoftlution.tallerSmartBackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cedula;
    private String address;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private UserRolModel rol;

    private String phone;
    private boolean active;

    @Column(columnDefinition = "TEXT")
    private String token;

    @Column(columnDefinition = "TEXT")
    private String tokenFirebase;

    private LocalDateTime creationDate;
    private String linkFotoPerfil;
}
