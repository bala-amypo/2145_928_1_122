package com.example.demo.service;

import com.example.demo.model.SaleTransaction;
import java.util.List;

public interface SaleTransactionService {

    SaleTransaction createSale(SaleTransaction sale);

    List<SaleTransaction> getSalesForCode(long codeId);

    List<SaleTransaction> getSalesForInfluencer(long influencerId);

    List<SaleTransaction> getSalesForCampaign(long campaignId);
}
