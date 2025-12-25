package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discount")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    @PostMapping
    public DiscountCode create(@RequestBody DiscountCode code) {
        return service.createDiscountCode(code);
    }

    // TEST EXPECTS THIS 👇
    @GetMapping("/{id}")
    public DiscountCode getDiscountCode(@PathVariable long id) {
        return service.getDiscountCodeById(id);
    }
}
