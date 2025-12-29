// package com.example.demo.model;

// import java.time.LocalDate;

// public class Campaign {
//     private Long id;
//     private String campaignName;
//     private LocalDate startDate;
//     private LocalDate endDate;

//     public Long getId() { return id; }
//     public String getCampaignName() { return campaignName; }
//     public LocalDate getStartDate() { return startDate; }
//     public LocalDate getEndDate() { return endDate; }

//     public void setId(Long id) { this.id = id; }
//     public void setCampaignName(String campaignName) { this.campaignName = campaignName; }
//     public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
//     public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
// }
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String campaignName;
    private BigDecimal budget;

    private LocalDate startDate;
    private LocalDate endDate;

    public Campaign() {}

    public Long getId() {
        return id;
    }

    // REQUIRED BY SERVICES & TESTS
    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
