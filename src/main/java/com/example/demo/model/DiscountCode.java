// package com.example.demo.model;

// public class DiscountCode {
//     private Long id;
//     private String codeValue;
//     private double discountPercentage;
//     private Influencer influencer;
//     private Campaign campaign;

//     public Long getId() { return id; }
//     public String getCodeValue() { return codeValue; }
//     public double getDiscountPercentage() { return discountPercentage; }
//     public Influencer getInfluencer() { return influencer; }
//     public Campaign getCampaign() { return campaign; }

//     public void setId(Long id) { this.id = id; }
//     public void setCodeValue(String codeValue) { this.codeValue = codeValue; }
//     public void setDiscountPercentage(double discountPercentage) { this.discountPercentage = discountPercentage; }
//     public void setInfluencer(Influencer influencer) { this.influencer = influencer; }
//     public void setCampaign(Campaign campaign) { this.campaign = campaign; }
// }
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "discount_code")
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private double discountPercentage;

    @ManyToOne
    private Influencer influencer;

    @ManyToOne
    private Campaign campaign;

    public DiscountCode() {}

    public Long getId() {
        return id;
    }

    // REQUIRED BY SERVICES & TESTS
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // alias (safe)
    public String getCodeValue() {
        return code;
    }

    public void setCodeValue(String codeValue) {
        this.code = codeValue;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
