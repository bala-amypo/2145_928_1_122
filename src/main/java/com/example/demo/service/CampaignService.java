// package com.example.demo.service;

// import java.util.List;
// import java.util.Optional;
// import com.example.demo.entity.Campaign;

// public interface CampaignService {
//     Campaign insertCampaign(Campaign c);
//     List<Campaign> getAllCampaigns();
//     Optional<Campaign> getCampaignById(Long id);
//     void deactivateCampaign(Long id);
// }
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Campaign;

public interface CampaignService {
    Campaign updateCampaign(Long id, Campaign campaign);
    Campaign getCampaignById(Long id);
    List<Campaign> getAllCampaigns();
}
