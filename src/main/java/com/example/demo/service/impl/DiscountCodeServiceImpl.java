package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;

    public DiscountCodeServiceImpl(DiscountCodeRepository discountCodeRepository) {
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return discountCodeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Discount code not found"));
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode updated) {

        if (updated.getDiscountPercentage() < 0 ||
                updated.getDiscountPercentage() > 100) {
            throw new IllegalArgumentException("Invalid discount percentage");
        }

        DiscountCode existing = discountCodeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Discount code not found"));

        existing.setCode(updated.getCode());
        existing.setDiscountPercentage(updated.getDiscountPercentage());

        return discountCodeRepository.save(existing);
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return discountCodeRepository.findByInfluencer_Id(influencerId);
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return discountCodeRepository.findByCampaign_Id(campaignId);
    }
}
