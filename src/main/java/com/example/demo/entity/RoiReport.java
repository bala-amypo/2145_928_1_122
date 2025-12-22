package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalSales;
    private BigDecimal totalRevenue;
    private BigDecimal roiPercentage;

    private Timestamp generatedAt = new Timestamp(System.currentTimeMillis());

    @ManyToOne
    private Campaign campaign;

    @ManyToOne
    private Influencer influencer;

    public RoiReport() {}

    public Long getId() {
        return id;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public Influencer getInfluencer() {
        return influencer;
    }
}
