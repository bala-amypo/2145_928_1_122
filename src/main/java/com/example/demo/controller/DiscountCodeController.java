package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;

import java.util.List;

public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    public DiscountCode getDiscountCode(long id) {
        return discountCodeService.getDiscountCodeById(id);
    }

    public DiscountCode updateDiscountCode(long id, DiscountCode dc) {
        return discountCodeService.updateDiscountCode(id, dc);
    }

    public List<DiscountCode> getCodesForInfluencer(long influencerId) {
        return discountCodeService.getCodesForInfluencer(influencerId);
    }

    public List<DiscountCode> getCodesForCampaign(long campaignId) {
        return discountCodeService.getCodesForCampaign(campaignId);
    }
}
