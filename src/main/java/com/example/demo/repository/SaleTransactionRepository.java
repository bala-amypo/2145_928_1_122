// package com.example.demo.repository;

// import com.example.demo.model.SaleTransaction;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {
// }
package com.example.demo.repository;

import com.example.demo.model.SaleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleTransactionRepository
        extends JpaRepository<SaleTransaction, Long> {

    // THIS METHOD WAS MISSING
    List<SaleTransaction> findByDiscountCode_Id(Long discountCodeId);
}
