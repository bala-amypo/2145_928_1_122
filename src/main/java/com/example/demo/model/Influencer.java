package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Influencer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String socialHandle;

    private String email;

    private Boolean active = true;

    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getSocialHandle() { return socialHandle; }
    public void setSocialHandle(String socialHandle) { this.socialHandle = socialHandle; }
    public void setActive(Boolean active) { this.active = active; }
}
