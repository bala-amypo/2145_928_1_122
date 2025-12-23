// package com.example.demo.service;

// import java.util.List;
// import java.util.Optional;
// import com.example.demo.entity.DiscountCode;

// public interface DiscountCodeService {
//     DiscountCode insertCode(DiscountCode d);
//     Optional<DiscountCode> getCodeById(Long id);
//     List<DiscountCode> getAllCodes();
//     void deactivateCode(Long id);
// }
package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.DiscountCode;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {

    List<DiscountCode> findByInfluencerId(Long influencerId);

    List<DiscountCode> findByCampaignId(Long campaignId);
}
