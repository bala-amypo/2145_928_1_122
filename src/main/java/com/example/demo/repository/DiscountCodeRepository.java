
package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.DiscountCode;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {
    DiscountCode findByCode(String code);
    List<DiscountCode> findByInfluencer_Id(Long influencerId);
    List<DiscountCode> findByCampaign_Id(Long campaignId);
}


