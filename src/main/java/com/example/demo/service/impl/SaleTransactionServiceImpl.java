package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Autowired
    SaleTransactionRepository repo;

    public SaleTransaction insertSale(SaleTransaction s) {
        return repo.save(s);
    }

    public Optional<SaleTransaction> getSaleById(Long id) {
        return repo.findById(id);
    }

    public List<SaleTransaction> getSalesByCode(Long codeId) {
        return repo.findByDiscountCode_Id(codeId);
    }
}
