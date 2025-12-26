package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    private final SaleTransactionService saleService;

    public SaleTransactionController(SaleTransactionService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<SaleTransaction> createSale(@RequestBody SaleTransaction tx) {
        return ResponseEntity.ok(saleService.createSale(tx));
    }

    @GetMapping("/code/{codeId}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCode(@PathVariable Long codeId) {
        return ResponseEntity.ok(saleService.getSalesForCode(codeId));
    }
}
