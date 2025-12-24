package com.example.demo.model;

import jakarta.persistence.*;     // 🔴 REQUIRED
import java.time.LocalDate;      // 🔴 REQUIRED
import java.math.BigDecimal;     // 🔴 REQUIRED

import java.sql.Timestamp;

@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String campaignName;

    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal budget;
    private Boolean active = true;

    public String getCampaignName() { return campaignName; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
}

