// package com.example.demo.model;

// import java.time.LocalDateTime;

// public class User {
//     private Long id;
//     private String email;
//     private String password;
//     private String role;
//     private LocalDateTime createdAt;

//     public Long getId() { return id; }
//     public String getEmail() { return email; }
//     public String getPassword() { return password; }
//     public String getRole() { return role; }
//     public LocalDateTime getCreatedAt() { return createdAt; }

//     public void setId(Long id) { this.id = id; }
//     public void setEmail(String email) { this.email = email; }
//     public void setPassword(String password) { this.password = password; }
//     public void setRole(String role) { this.role = role; }
//     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
// }

package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    private LocalDateTime createdAt = LocalDateTime.now();

    // ---------- GETTERS ----------

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ---------- SETTERS (NO setId) ----------

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
