package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import org.springframework.web.bind.annotation.*;

@RestController
public class SaleTransactionController {

    @PostMapping("/sale")
    public SaleTransaction createSale(@RequestBody SaleTransaction sale) {
        return sale;
    }
}
