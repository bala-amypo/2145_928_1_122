// package com.example.demo.service.impl;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.stereotype.Service;

// import com.example.demo.entity.SaleTransaction;
// import com.example.demo.repository.SaleTransactionRepository;
// import com.example.demo.service.SaleTransactionService;

// @Service
// public class SaleTransactionServiceImpl implements SaleTransactionService {

//     private final SaleTransactionRepository repo;

//     public SaleTransactionServiceImpl(SaleTransactionRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public SaleTransaction insertSale(SaleTransaction s) {
//         return repo.save(s);
//     }

//     @Override
//     public Optional<SaleTransaction> getSaleById(Long id) {
//         return repo.findById(id);
//     }

//     @Override
//     public List<SaleTransaction> getSalesByCode(Long codeId) {
//         return repo.findByDiscountCode_Id(codeId);
//     }
// }
package com.example.demo.service.impl;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;

    public SaleTransactionServiceImpl(SaleTransactionRepository saleTransactionRepository,
                                      DiscountCodeRepository discountCodeRepository) {
        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public SaleTransaction createSale(SaleTransaction transaction) {
        if (transaction.getTransactionAmount().doubleValue() <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }

        discountCodeRepository.findById(transaction.getDiscountCode().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

        if (transaction.getTransactionDate() == null) {
            transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        }

        return saleTransactionRepository.save(transaction);
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long discountCodeId) {
        return saleTransactionRepository.findByDiscountCodeId(discountCodeId);
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return saleTransactionRepository.findByDiscountCodeInfluencerId(influencerId);
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return saleTransactionRepository.findByDiscountCodeCampaignId(campaignId);
    }
}
