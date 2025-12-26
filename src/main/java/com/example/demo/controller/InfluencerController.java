package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import java.util.List;

public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    public Influencer createInfluencer(Influencer influencer) {
        return influencerService.createInfluencer(influencer);
    }

    public List<Influencer> getAllInfluencers() {
        return influencerService.getAllInfluencers();
    }

    public Influencer getInfluencer(long id) {
        return influencerService.getInfluencerById(id);
    }
}
