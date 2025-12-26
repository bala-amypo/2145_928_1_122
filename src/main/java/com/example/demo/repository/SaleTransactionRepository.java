package com.example.demo.repository;

import com.example.demo.model.SaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {

    // 🔹 REQUIRED BY RoiServiceImpl
    List<SaleTransaction> findByDiscountCodeId(Long discountCodeId);
}
