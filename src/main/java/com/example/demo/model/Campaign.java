// package com.example.demo.entity;

// import java.math.BigDecimal;
// import java.util.Date;

// import jakarta.persistence.*;

// @Entity
// public class Campaign {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String campaignName;

//     @Temporal(TemporalType.DATE)
//     private Date startDate;

//     @Temporal(TemporalType.DATE)
//     private Date endDate;

//     private BigDecimal budget;

//     private Boolean active = true;

//     public Campaign() {}

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getCampaignName() {
//         return campaignName;
//     }
 
//     public void setCampaignName(String campaignName) {
//         this.campaignName = campaignName;
//     }

//     public Date getStartDate() {
//         return startDate;
//     }
 
//     public void setStartDate(Date startDate) {
//         this.startDate = startDate;
//     }

//     public Date getEndDate() {
//         return endDate;
//     }
 
//     public void setEndDate(Date endDate) {
//         this.endDate = endDate;
//     }

//     public BigDecimal getBudget() {
//         return budget;
//     }
 
//     public void setBudget(BigDecimal budget) {
//         this.budget = budget;
//     }

//     public Boolean getActive() {
//         return active;
//     }
 
//     public void setActive(Boolean active) {
//         this.active = active;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String campaignName;

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "campaign")
    private List<DiscountCode> discountCodes;

    public Campaign() {}

    public Campaign(String campaignName, LocalDate startDate, LocalDate endDate) {
        this.campaignName = campaignName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() { return id; }
    public String getCampaignName() { return campaignName; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    public void setCampaignName(String campaignName) { this.campaignName = campaignName; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}
