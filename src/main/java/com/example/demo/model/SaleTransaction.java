package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class SaleTransaction {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private DiscountCode discountCode;

    private BigDecimal saleAmount;
    private Timestamp transactionDate;

    @PrePersist
    void onCreate() {
        transactionDate = new Timestamp(System.currentTimeMillis());
    }

    // getters & setters
}
