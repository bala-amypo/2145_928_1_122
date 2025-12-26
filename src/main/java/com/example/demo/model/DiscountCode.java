package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private Double discountPercentage;

    // ---------- getters & setters ----------

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCodeValue(String code) {
        this.code = code;
    }

    public String getCodeValue() {
        return code;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
