// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class DiscountCode {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true)
//     private String code;

//     private Double discountPercentage;

//     private Boolean active = true;

//     @ManyToOne
//     @JoinColumn(name = "influencer_id")
//     private Influencer influencer;

//     @ManyToOne
//     @JoinColumn(name = "campaign_id")
//     private Campaign campaign;

//     public DiscountCode() {}

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getCode() {
//         return code;
//     }
 
//     public void setCode(String code) {
//         this.code = code;
//     }

//     public Double getDiscountPercentage() {
//         return discountPercentage;
//     }

//     public void setDiscountPercentage(Double discountPercentage) {
//         this.discountPercentage = discountPercentage;
//     }

//     public Boolean getActive() {
//         return active;
//     }
 
//     public void setActive(Boolean active) {
//         this.active = active;
//     }

//     public Influencer getInfluencer() {
//         return influencer;
//     }

//     public void setInfluencer(Influencer influencer) {
//         this.influencer = influencer;
//     }

//     public Campaign getCampaign() {
//         return campaign;
//     }

//     public void setCampaign(Campaign campaign) {
//         this.campaign = campaign;
//     }
// }


package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "discount_codes")
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeValue;
    private double discountPercentage;

    @ManyToOne
    private Campaign campaign;

    @ManyToOne
    private Influencer influencer;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    // ===== SETTERS =====
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }
}
