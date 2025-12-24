package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;

    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
        if (role == null) role = "MARKETER";
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
