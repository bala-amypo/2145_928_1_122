package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository repository;

    public SaleTransactionServiceImpl(SaleTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public SaleTransaction createSaleTransaction(SaleTransaction saleTransaction) {
        return repository.save(saleTransaction);
    }
}
