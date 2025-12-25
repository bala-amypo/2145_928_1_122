package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DiscountCode {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    public Long getId() { return id; }

    // Original
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    // TEST EXPECTS THESE 👇
    public String getCodeValue() { return code; }
    public void setCodeValue(String codeValue) {
        this.code = codeValue;
    }
}
