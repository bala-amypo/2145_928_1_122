package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DiscountCode;
import com.example.demo.service.DiscountCodeService;

@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    @Autowired
    DiscountCodeService service;

    @PostMapping("/add")
    public DiscountCode add(@RequestBody DiscountCode d) {
        return service.insertCode(d);
    }

    @GetMapping("/getAll")
    public List<DiscountCode> getAll() {
        return service.getAllCodes();
    }

    @GetMapping("/get/{id}")
    public Optional<DiscountCode> get(@PathVariable Long id) {
        return service.getCodeById(id);
    }

    @PutMapping("/deactivate/{id}")
    public String deactivate(@PathVariable Long id) {
        service.deactivateCode(id);
        return "Deactivated";
    }
}
