package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository repo;

    public SaleTransactionServiceImpl(SaleTransactionRepository repo) {
        this.repo = repo;
    }

    @Override
    public SaleTransaction insertSale(SaleTransaction s) {
        return repo.save(s);
    }

    @Override
    public Optional<SaleTransaction> getSaleById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<SaleTransaction> getSalesByCode(Long codeId) {
        return repo.findByDiscountCode_Id(codeId);
    }
}
