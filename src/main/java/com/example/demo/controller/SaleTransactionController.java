package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    @PostMapping
    public SaleTransaction create(@RequestBody SaleTransaction transaction) {
        return saleTransactionService.logTransaction(transaction);
    }

    @GetMapping("/{id}")
    public SaleTransaction getById(@PathVariable Long id) {
        return saleTransactionService.getTransactionById(id);
    }

    @GetMapping("/code/{codeId}")
    public List<SaleTransaction> getByCode(@PathVariable Long codeId) {
        return saleTransactionService.getSalesForCode(codeId);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<SaleTransaction> getByInfluencer(@PathVariable Long influencerId) {
        return saleTransactionService.getSalesForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<SaleTransaction> getByCampaign(@PathVariable Long campaignId) {
        return saleTransactionService.getSalesForCampaign(campaignId);
    }
}
