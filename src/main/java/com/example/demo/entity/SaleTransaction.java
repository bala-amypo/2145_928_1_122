// package com.example.demo.entity;

// import java.math.BigDecimal;
// import java.sql.Timestamp;

// import jakarta.persistence.*;

// @Entity
// public class SaleTransaction {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "discount_code_id")
//     private DiscountCode discountCode;

//     private BigDecimal saleAmount;

//     private Timestamp transactionDate = new Timestamp(System.currentTimeMillis());

//     public Long getId() {
//         return id;
//     }

//     public DiscountCode getDiscountCode() {
//         return discountCode;
//     }

//     public void setDiscountCode(DiscountCode discountCode) {
//         this.discountCode = discountCode;
//     }

//     public BigDecimal getSaleAmount() {
//         return saleAmount;
//     }

//     public void setSaleAmount(BigDecimal saleAmount) {
//         this.saleAmount = saleAmount;
//     }
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

    @ManyToOne
    private DiscountCode discountCode;

    private BigDecimal transactionAmount;
    private Timestamp transactionDate;
    private Long customerId;

    public SaleTransaction() {}

    public SaleTransaction(DiscountCode discountCode, BigDecimal transactionAmount,
                           Timestamp transactionDate, Long customerId) {
        this.discountCode = discountCode;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.customerId = customerId;
    }

    public Long getId() { return id; }
    public DiscountCode getDiscountCode() { return discountCode; }
    public BigDecimal getTransactionAmount() { return transactionAmount; }
    public Timestamp getTransactionDate() { return transactionDate; }
    public Long getCustomerId() { return customerId; }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }
}
