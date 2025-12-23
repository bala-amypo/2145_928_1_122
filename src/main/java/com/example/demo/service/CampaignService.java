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
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
