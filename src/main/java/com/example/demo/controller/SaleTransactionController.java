package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;

import java.util.List;

public class SaleTransactionController {

    private final SaleTransactionService saleService;

    public SaleTransactionController(SaleTransactionService saleService) {
        this.saleService = saleService;
    }

    public SaleTransaction createSale(SaleTransaction tx) {
        return saleService.createSale(tx);
    }

    public List<SaleTransaction> getSalesForCode(long codeId) {
        return saleService.getSalesForCode(codeId);
    }
}
