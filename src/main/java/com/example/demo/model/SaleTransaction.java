// package com.example.demo.model;

// import java.math.BigDecimal;
// import java.sql.Timestamp;

// public class SaleTransaction {
//     private Long id;
//     private BigDecimal transactionAmount;
//     private Timestamp transactionDate;
//     private DiscountCode discountCode;
//     private Long customerId;

//     public BigDecimal getTransactionAmount() { return transactionAmount; }
//     public Timestamp getTransactionDate() { return transactionDate; }
//     public DiscountCode getDiscountCode() { return discountCode; }
//     public Long getCustomerId() { return customerId; }

//     public void setTransactionAmount(BigDecimal transactionAmount) { this.transactionAmount = transactionAmount; }
//     public void setTransactionDate(Timestamp transactionDate) { this.transactionDate = transactionDate; }
//     public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
//     public void setCustomerId(Long customerId) { this.customerId = customerId; }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "sale_transactions")
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Required by tests
    @Column(nullable = false)
    private BigDecimal transactionAmount;

    // Required by tests
    private Long customerId;

    // Required by tests
    private Timestamp transactionDate;

    // Required by tests (association)
    @ManyToOne
    @JoinColumn(name = "discount_code_id")
    private DiscountCode discountCode;

    // ---------- GETTERS ----------

    public Long getId() {
        return id;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    // ---------- SETTERS ----------

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }
}
