package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Override
    public SaleTransaction createSale(SaleTransaction sale) {
        return sale;
    }

    @Override
    public List<SaleTransaction> getSalesForCode(long codeId) {
        return List.of();
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(long influencerId) {
        return List.of();
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(long campaignId) {
        return List.of();
    }
}
