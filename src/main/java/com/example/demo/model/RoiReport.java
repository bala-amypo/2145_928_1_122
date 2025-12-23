// package com.example.demo.entity;

// import java.math.BigDecimal;
// import java.sql.Timestamp;

// import jakarta.persistence.*;

// @Entity
// public class RoiReport {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private BigDecimal totalSales;
//     private BigDecimal totalRevenue;
//     private BigDecimal roiPercentage;

//     private Timestamp generatedAt = new Timestamp(System.currentTimeMillis());

//     @ManyToOne
//     private Campaign campaign;

//     @ManyToOne
//     private Influencer influencer;

//     public RoiReport() {}

//     public Long getId() {
//         return id;
//     }

//     public Campaign getCampaign() {
//         return campaign;
//     }

//     public Influencer getInfluencer() {
//         return influencer;
//     }
// }
package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "roi_reports")
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ IMPORTED CORRECTLY FROM SAME PACKAGE
    @ManyToOne
    @JoinColumn(name = "discount_code_id")
    private DiscountCode discountCode;

    private BigDecimal totalSales;

    private Integer totalTransactions;

    private Double roiPercentage;

    // ✅ REQUIRED BY JPA
    public RoiReport() {
    }

    // ✅ USED BY SERVICE
    public RoiReport(DiscountCode discountCode,
                     BigDecimal totalSales,
                     Integer totalTransactions,
                     Double roiPercentage) {
        this.discountCode = discountCode;
        this.totalSales = totalSales;
        this.totalTransactions = totalTransactions;
        this.roiPercentage = roiPercentage;
    }

    public Long getId() {
        return id;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public Integer getTotalTransactions() {
        return totalTransactions;
    }

    public Double getRoiPercentage() {
        return roiPercentage;
    }
}
