package com.example.demo.repository;

import com.example.demo.model.DiscountCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {

    // 🔹 REQUIRED BY SERVICE + TESTS
    List<DiscountCode> findByInfluencerId(Long influencerId);

    // 🔹 REQUIRED BY SERVICE + TESTS
    List<DiscountCode> findByCampaignId(Long campaignId);
}
