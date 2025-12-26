package com.example.demo.controller;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")

public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    public Campaign updateCampaign(long id, Campaign campaign) {
        return campaignService.updateCampaign(id, campaign);
    }

    public Campaign getCampaign(long id) {
        return campaignService.getCampaignById(id);
    }

    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }
}
