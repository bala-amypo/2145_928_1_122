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

package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "sale_transactions")
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal transactionAmount;
    private Timestamp transactionDate;

    @ManyToOne
    private DiscountCode discountCode;

    public SaleTransaction() {}

    public SaleTransaction(BigDecimal amount, DiscountCode code) {
        this.transactionAmount = amount;
        this.discountCode = code;
        this.transactionDate = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() { return id; }
    public BigDecimal getTransactionAmount() { return transactionAmount; }
    public DiscountCode getDiscountCode() { return discountCode; }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }
}
