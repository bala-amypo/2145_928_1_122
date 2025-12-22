package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RoiReport {

    private Long id;
    private Campaign campaign;
    private Influencer influencer;
    private BigDecimal totalSales;
    private BigDecimal totalRevenue;
    private BigDecimal roiPercentage;
    private Timestamp generatedAt = new Timestamp(System.currentTimeMillis());

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }
}
