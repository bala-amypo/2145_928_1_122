package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;

    private String campaignName;

    private BigDecimal budget;

    public Long getId() { return id; }

    public String getCampaignName() { return campaignName; }
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
