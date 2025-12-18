package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SaleTransaction {
    private Long id;
    private DiscountCode discountCode;
    private BigDecimal saleAmount;
    private Timestamp transactionDate = new Timestamp(System.currentTimeMillis());

    public SaleTransaction() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public DiscountCode getDiscountCode() { return discountCode; }
    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getSaleAmount() { return saleAmount; }
    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }
}
