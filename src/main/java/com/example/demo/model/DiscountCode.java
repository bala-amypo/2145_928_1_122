package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DiscountCode {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String code;

    @ManyToOne
    private Influencer influencer;

    @ManyToOne
    private Campaign campaign;

    private Double discountPercentage;

    private Boolean active = true;

    // ✅ GETTERS & SETTERS
    public Long getId() { return id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
