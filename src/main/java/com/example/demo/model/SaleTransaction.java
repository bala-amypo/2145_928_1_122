package com.example.demo.model;

import java.math.BigDecimal;

public class SaleTransaction {

    private Long id;
    private BigDecimal transactionAmount;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getTransactionAmount() { return transactionAmount; }
    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
