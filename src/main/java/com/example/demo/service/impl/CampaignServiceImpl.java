// package com.example.demo.service.impl;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.Campaign;
// import com.example.demo.repository.CampaignRepository;
// import com.example.demo.service.CampaignService;

// @Service
// public class CampaignServiceImpl implements CampaignService {

//     @Autowired
//     CampaignRepository repo;

//     public Campaign insertCampaign(Campaign c) {
//         return repo.save(c);
//     }

//     public List<Campaign> getAllCampaigns() {
//         return repo.findAll();
//     }

//     public Optional<Campaign> getCampaignById(Long id) {
//         return repo.findById(id);
//     }

//     public void deactivateCampaign(Long id) {
//         repo.findById(id).ifPresent(c -> c.setActive(false));
//     }
// }
package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {
        Campaign existing = campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));

        if (campaign.getEndDate().isBefore(campaign.getStartDate())) {
            throw new IllegalArgumentException("Invalid date range");
        }

        existing.setCampaignName(campaign.getCampaignName());
        existing.setStartDate(campaign.getStartDate());
        existing.setEndDate(campaign.getEndDate());

        return campaignRepository.save(existing);
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }
}
