package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "roi_reports")
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Campaign campaign;

    @ManyToOne
    private Influencer influencer;

    private BigDecimal totalSales;

    private BigDecimal totalRevenue;

    private BigDecimal roiPercentage;

    private LocalDateTime generatedAt;

    public RoiReport() {}

    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    // getters and setters
    public Long getId() { return id; }
    public Campaign getCampaign() { return campaign; }
    public Influencer getInfluencer() { return influencer; }
    public BigDecimal getTotalSales() { return totalSales; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public BigDecimal getRoiPercentage() { return roiPercentage; }

    public void setCampaign(Campaign campaign) { this.campaign = campaign; }
    public void setInfluencer(Influencer influencer) { this.influencer = influencer; }
    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
    public void setTotalRevenue(BigDecimal totalRevenue) { this.totalRevenue = totalRevenue; }
    public void setRoiPercentage(BigDecimal roiPercentage) { this.roiPercentage = roiPercentage; }
}
