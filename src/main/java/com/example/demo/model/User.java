package com.example.demo.model;

import java.time.LocalDateTime;

public class User {

    private Long id;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    public User() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) { // REQUIRED
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) { // REQUIRED
        this.createdAt = createdAt;
    }
}
