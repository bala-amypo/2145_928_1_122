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

package com.example.demo.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "roi_reports")
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DiscountCode discountCode;

    private BigDecimal totalSales;
    private Integer totalTransactions;
    private Double roiPercentage;

    public RoiReport() {}

    public RoiReport(DiscountCode code, BigDecimal totalSales,
                     Integer totalTransactions, Double roiPercentage) {
        this.discountCode = code;
        this.totalSales = totalSales;
        this.totalTransactions = totalTransactions;
        this.roiPercentage = roiPercentage;
    }

    public Long getId() { return id; }
}
