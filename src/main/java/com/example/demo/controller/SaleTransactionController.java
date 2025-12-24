package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SaleTransaction;

@RestController
@RequestMapping("/sales")
public class SaleTransactionController {

    @GetMapping("/code/{id}")
    public ResponseEntity<List<SaleTransaction>> getSalesForCode(@PathVariable long id) {
        return ResponseEntity.ok(List.of());
    }
}
