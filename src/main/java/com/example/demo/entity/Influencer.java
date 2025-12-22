package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String socialHandle;
    private String email;
    private Boolean active = true;

    @OneToMany(mappedBy = "influencer")
    private List<DiscountCode> discountCodes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSocialHandle() { return socialHandle; }
    public void setSocialHandle(String socialHandle) { this.socialHandle = socialHandle; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
