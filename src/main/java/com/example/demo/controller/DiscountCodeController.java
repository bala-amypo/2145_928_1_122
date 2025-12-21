package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DiscountCode;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.DiscountCodeService;

@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<DiscountCode> add(
            @Valid @RequestBody DiscountCode d) {

        return ResponseEntity.ok(service.insertCode(d));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DiscountCode>> getAll() {
        return ResponseEntity.ok(service.getAllCodes());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DiscountCode> get(@PathVariable Long id) {

        DiscountCode code = service.getCodeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

        return ResponseEntity.ok(code);
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {

        service.deactivateCode(id);
        return ResponseEntity.ok("Discount code deactivated");
    }
}
