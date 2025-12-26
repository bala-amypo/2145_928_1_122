package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository repository;

    public DiscountCodeServiceImpl(DiscountCodeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiscountCode createDiscountCode(DiscountCode discountCode) {
        return repository.save(discountCode);
    }

    @Override
    public DiscountCode getDiscountCode(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 🔹 ALIAS FOR TEST
    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return getDiscountCode(id);
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode discountCode) {
        DiscountCode existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setCodeValue(discountCode.getCodeValue());
        existing.setDiscountPercentage(discountCode.getDiscountPercentage());
        return repository.save(existing);
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return repository.findByInfluencerId(influencerId);
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return repository.findByCampaignId(campaignId);
    }
}
