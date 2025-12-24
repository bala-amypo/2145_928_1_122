package com.example.demo.model;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // getters + setters
}
