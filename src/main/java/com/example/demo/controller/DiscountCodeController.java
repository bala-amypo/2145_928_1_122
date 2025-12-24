package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiscountCodeController {

    @GetMapping("/discount-code/{id}")
    public DiscountCode getDiscountCode(@PathVariable long id) {
        return new DiscountCode();
    }
}
