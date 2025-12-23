package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discount_code_id")
    private DiscountCode discountCode;

    private BigDecimal saleAmount;

    private Timestamp transactionDate = new Timestamp(System.currentTimeMillis());

    public Long getId() {
        return id;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }
}
