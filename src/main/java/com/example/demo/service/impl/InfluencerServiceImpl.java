package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    @Autowired
    InfluencerRepository repo;

    public Influencer insertInfluencer(Influencer i) {
        return repo.save(i);
    }

    public List<Influencer> getAllInfluencers() {
        return repo.findAll();
    }

    public Optional<Influencer> getInfluencerById(Long id) {
        return repo.findById(id);
    }

    public void deactivateInfluencer(Long id) {
        repo.findById(id).ifPresent(i -> i.setActive(false));
    }
}
