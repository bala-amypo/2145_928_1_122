package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SaleTransaction;
import com.example.demo.service.SaleTransactionService;

@RestController
@RequestMapping("/api/sales")
public class SaleTransactionController {

    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<SaleTransaction> add(
            @Valid @RequestBody SaleTransaction s) {
        return ResponseEntity.ok(service.insertSale(s));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SaleTransaction> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSaleById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found")));
    }

    @GetMapping("/code/{codeId}")
    public ResponseEntity<List<SaleTransaction>> getByCode(
            @PathVariable Long codeId) {
        return ResponseEntity.ok(service.getSalesByCode(codeId));
    }
}
