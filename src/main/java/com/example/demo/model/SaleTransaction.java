package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SaleTransaction {

    private Long id;
    private BigDecimal transactionAmount;
    private LocalDateTime transactionDate;
    private long customerId;
    private DiscountCode discountCode;

    public SaleTransaction() {}

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) { // REQUIRED
        this.transactionAmount = transactionAmount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) { // REQUIRED
        this.transactionDate = transactionDate;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) { // REQUIRED
        this.customerId = customerId;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode discountCode) { // REQUIRED
        this.discountCode = discountCode;
    }
}
