package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SaleTransaction;
import com.example.demo.service.SaleTransactionService;

@RestController
@RequestMapping("/api/sales")
public class SaleTransactionController {

    @Autowired
    SaleTransactionService service;

    @PostMapping("/add")
    public SaleTransaction add(@RequestBody SaleTransaction s) {
        return service.insertSale(s);
    }

    @GetMapping("/get/{id}")
    public Optional<SaleTransaction> get(@PathVariable Long id) {
        return service.getSaleById(id);
    }

    @GetMapping("/code/{codeId}")
    public List<SaleTransaction> getByCode(@PathVariable Long codeId) {
        return service.getSalesByCode(codeId);
    }
}
