package com.example.demo.model;

public class DiscountCode {

    private Long id;
    private Influencer influencer;
    private Campaign campaign;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Influencer getInfluencer() { return influencer; }
    public void setInfluencer(Influencer influencer) { this.influencer = influencer; }

    public Campaign getCampaign() { return campaign; }
    public void setCampaign(Campaign campaign) { this.campaign = campaign; }
}
