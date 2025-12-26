package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleService;

    public SaleTransactionController(SaleTransactionService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public SaleTransaction create(@RequestBody SaleTransaction tx) {
        return saleService.createSale(tx);
    }

    @GetMapping("/code/{codeId}")
    public List<SaleTransaction> getByCode(@PathVariable Long codeId) {
        return saleService.getSalesForCode(codeId);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<SaleTransaction> getByInfluencer(
            @PathVariable Long influencerId) {
        return saleService.getSalesForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<SaleTransaction> getByCampaign(
            @PathVariable Long campaignId) {
        return saleService.getSalesForCampaign(campaignId);
    }
}
