package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;

@RestController
@RequestMapping("/api/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleTransactionService;

    public SaleTransactionController(SaleTransactionService saleTransactionService) {
        this.saleTransactionService = saleTransactionService;
    }

    // 🔥 TEST EXPECTS THIS NAME
    @PostMapping
    public ResponseEntity<SaleTransaction> createSaleTransaction(
            @RequestBody SaleTransaction saleTransaction) {
        return new ResponseEntity<>(
                saleTransactionService.createSaleTransaction(saleTransaction),
                HttpStatus.CREATED
        );
    }
}
