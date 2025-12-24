// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "users")   
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String fullName;

//     @Column(unique = true)
//     private String email;

//     private String password;
//     private String role;

//     public Long getId() {
//         return id;
//     }

//     public String getFullName() {
//         return fullName;
//     }

//     public void setFullName(String fullName) {
//         this.fullName = fullName;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getPassword() {
//         return password;
//     }
 
//     public void setPassword(String password) {
//         this.password = password;
//     }
 
//     public String getRole() {
//         return role;
//     }
 
//     public void setRole(String role) {
//         this.role = role;
//     }
// }

package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;
    private String password;
    private String role;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // ===== SETTERS =====
    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
