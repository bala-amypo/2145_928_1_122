package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SaleTransaction;

@Repository
public interface SaleTransactionRepository
        extends JpaRepository<SaleTransaction, Long> {

    // ✅ MUST MATCH ENTITY FIELD NAME
    List<SaleTransaction> findByDiscountCode_Id(Long codeId);
}
