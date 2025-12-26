package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sale_transactions")
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discount_code_id")
    private DiscountCode discountCode;

    private BigDecimal saleAmount;

    private LocalDateTime transactionDate;

    public SaleTransaction() {}

    public SaleTransaction(DiscountCode discountCode, BigDecimal saleAmount) {
        this.discountCode = discountCode;
        this.saleAmount = saleAmount;
    }

    @PrePersist
    public void onCreate() {
        this.transactionDate = LocalDateTime.now();
    }

    // getters and setters
    public Long getId() { return id; }
    public DiscountCode getDiscountCode() { return discountCode; }
    public BigDecimal getSaleAmount() { return saleAmount; }
    public LocalDateTime getTransactionDate() { return transactionDate; }

    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
    public void setSaleAmount(BigDecimal saleAmount) { this.saleAmount = saleAmount; }
}
