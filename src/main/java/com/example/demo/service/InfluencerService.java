package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Influencer;

public interface InfluencerService {
    Influencer insertInfluencer(Influencer i);
    List<Influencer> getAllInfluencers();
    Optional<Influencer> getInfluencerById(Long id);
    void deactivateInfluencer(Long id);
}
