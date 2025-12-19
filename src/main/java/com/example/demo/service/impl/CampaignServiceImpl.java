package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    CampaignRepository repo;

    public Campaign insertCampaign(Campaign c) {
        return repo.save(c);
    }

    public List<Campaign> getAllCampaigns() {
        return repo.findAll();
    }

    public Optional<Campaign> getCampaignById(Long id) {
        return repo.findById(id);
    }

    public void deactivateCampaign(Long id) {
        repo.findById(id).ifPresent(c -> c.setActive(false));
    }
}
