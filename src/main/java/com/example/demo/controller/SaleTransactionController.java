package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    @PostMapping
    public SaleTransaction createSale(@RequestBody SaleTransaction saleTransaction) {
        return saleTransactionService.createSaleTransaction(saleTransaction);
    }
}
