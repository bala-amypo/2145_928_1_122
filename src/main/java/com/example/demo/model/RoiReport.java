// package com.example.demo.model;

// import java.math.BigDecimal;

// public class RoiReport {
//     private BigDecimal totalSales;
//     private int totalTransactions;
//     private double roiPercentage;
//     private DiscountCode discountCode;

//     public BigDecimal getTotalSales() { return totalSales; }
//     public int getTotalTransactions() { return totalTransactions; }
//     public double getRoiPercentage() { return roiPercentage; }
//     public DiscountCode getDiscountCode() { return discountCode; }

//     public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
//     public void setTotalTransactions(int totalTransactions) { this.totalTransactions = totalTransactions; }
//     public void setRoiPercentage(double roiPercentage) { this.roiPercentage = roiPercentage; }
//     public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
// }
package com.example.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "roi_report")
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalSales;
    private BigDecimal totalRevenue;
    private BigDecimal roiPercentage;
    private int totalTransactions;

    @ManyToOne
    @JoinColumn(name = "discount_code_id")
    private DiscountCode discountCode;

    public RoiReport() {}

    public Long getId() {
        return id;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public BigDecimal getRoiPercentage() {
        return roiPercentage;
    }

    public void setRoiPercentage(BigDecimal roiPercentage) {
        this.roiPercentage = roiPercentage;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }
}
