package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String socialHandle;
    private boolean active = true;

    // ---------- getters & setters ----------

    public Long getId() {
        return id;
    }

    public String getSocialHandle() {
        return socialHandle;
    }

    public void setSocialHandle(String socialHandle) {
        this.socialHandle = socialHandle;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
