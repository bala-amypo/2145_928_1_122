package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class SaleTransaction {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private DiscountCode discountCode;

    private BigDecimal saleAmount;

    private LocalDateTime transactionDate;

    @PrePersist
    void onCreate() {
        transactionDate = LocalDateTime.now();
    }

    // ✅ GETTERS & SETTERS
    public Long getId() { return id; }

    public DiscountCode getDiscountCode() { return discountCode; }
    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getSaleAmount() { return saleAmount; }
    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }
}
