package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Campaign;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    @PutMapping("/{id}")
    public ResponseEntity<Campaign> updateCampaign(
            @PathVariable long id,
            @RequestBody Campaign campaign) {
        return ResponseEntity.ok(campaign);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaign(@PathVariable long id) {
        return ResponseEntity.ok(new Campaign());
    }

    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        return ResponseEntity.ok(List.of());
    }
}
