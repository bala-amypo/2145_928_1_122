package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @GetMapping("/{id}")
    public DiscountCode getById(@PathVariable Long id) {
        return discountCodeService.getDiscountCodeById(id);
    }

    @PutMapping("/{id}")
    public DiscountCode update(@PathVariable Long id,
                               @RequestBody DiscountCode code) {
        return discountCodeService.updateDiscountCode(id, code);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<DiscountCode> getForInfluencer(
            @PathVariable Long influencerId) {
        return discountCodeService.getCodesForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<DiscountCode> getForCampaign(
            @PathVariable Long campaignId) {
        return discountCodeService.getCodesForCampaign(campaignId);
    }
}
