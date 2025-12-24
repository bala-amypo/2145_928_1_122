package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DiscountCode;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> updateDiscountCode(
            @PathVariable long id,
            @RequestBody DiscountCode code) {
        return ResponseEntity.ok(code);
    }

    @GetMapping("/influencer/{id}")
    public ResponseEntity<List<DiscountCode>> getCodesForInfluencer(@PathVariable long id) {
        return ResponseEntity.ok(List.of());
    }

    @GetMapping("/campaign/{id}")
    public ResponseEntity<List<DiscountCode>> getCodesForCampaign(@PathVariable long id) {
        return ResponseEntity.ok(List.of());
    }
}
