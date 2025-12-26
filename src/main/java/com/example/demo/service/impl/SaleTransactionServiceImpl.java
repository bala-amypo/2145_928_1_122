package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DiscountCode;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleRepo;
    private final DiscountCodeRepository codeRepo;

    public SaleTransactionServiceImpl(SaleTransactionRepository saleRepo,
                                      DiscountCodeRepository codeRepo) {
        this.saleRepo = saleRepo;
        this.codeRepo = codeRepo;
    }

    @Override
    public SaleTransaction createSale(SaleTransaction transaction) {

        BigDecimal amount = transaction.getSaleAmount();
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }

        DiscountCode code = codeRepo.findById(
                transaction.getDiscountCode().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Discount code not found"));

        transaction.setDiscountCode(code);

        return saleRepo.save(transaction);
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long discountCodeId) {
        return saleRepo.findByDiscountCode_Id(discountCodeId);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return saleRepo.findByDiscountCode_Influencer_Id(influencerId);
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return saleRepo.findByDiscountCode_Campaign_Id(campaignId);
    }
}
