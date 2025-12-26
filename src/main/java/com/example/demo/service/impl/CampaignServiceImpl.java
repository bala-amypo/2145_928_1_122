package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {

        Campaign existing = campaignRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Campaign not found"));

        LocalDate start = campaign.getStartDate();
        LocalDate end = campaign.getEndDate();

        if (start != null && end != null && end.isBefore(start)) {
            throw new IllegalArgumentException("Invalid date range");
        }

        existing.setCampaignName(campaign.getCampaignName());
        existing.setStartDate(start);
        existing.setEndDate(end);

        return campaignRepository.save(existing);
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Campaign not found"));
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }
}
