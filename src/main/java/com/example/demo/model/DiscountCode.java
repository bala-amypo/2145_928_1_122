package com.example.demo.model;

public class DiscountCode {

    private Long id;
    private String codeValue;
    private double discountPercentage;

    public DiscountCode() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) { // REQUIRED
        this.codeValue = codeValue;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) { // REQUIRED
        this.discountPercentage = discountPercentage;
    }
}
