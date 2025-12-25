package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Influencer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String socialHandle;

    private Boolean active = true;

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSocialHandle() { return socialHandle; }
    public void setSocialHandle(String socialHandle) {
        this.socialHandle = socialHandle;
    }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
