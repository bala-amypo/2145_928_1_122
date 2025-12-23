// package com.example.demo.service;

// import java.util.List;
// import java.util.Optional;
// import com.example.demo.entity.SaleTransaction;

// public interface SaleTransactionService {
//     SaleTransaction insertSale(SaleTransaction s);
//     Optional<SaleTransaction> getSaleById(Long id);
//     List<SaleTransaction> getSalesByCode(Long codeId);
// }
package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.SaleTransaction;

public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {

    List<SaleTransaction> findByDiscountCodeId(Long discountCodeId);

    List<SaleTransaction> findByDiscountCodeInfluencerId(Long influencerId);

    List<SaleTransaction> findByDiscountCodeCampaignId(Long campaignId);
}
