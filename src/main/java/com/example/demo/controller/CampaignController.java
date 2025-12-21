package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Campaign;
import com.example.demo.service.CampaignService;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    private final CampaignService service;

    public CampaignController(CampaignService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Campaign> add(
            @Valid @RequestBody Campaign c) {
        return ResponseEntity.ok(service.insertCampaign(c));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Campaign>> getAll() {
        return ResponseEntity.ok(service.getAllCampaigns());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Campaign> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCampaignById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found")));
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {
        service.deactivateCampaign(id);
        return ResponseEntity.ok("Campaign deactivated");
    }
}
