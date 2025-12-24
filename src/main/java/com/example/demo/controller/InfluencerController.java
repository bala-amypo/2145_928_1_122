package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Influencer;
import com.example.demo.service.InfluencerService;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    // 🔥 TEST EXPECTS THIS NAME
    @PostMapping
    public ResponseEntity<Influencer> createInfluencer(@RequestBody Influencer influencer) {
        return new ResponseEntity<>(
                influencerService.createInfluencer(influencer),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getInfluencer(@PathVariable Long id) {
        return ResponseEntity.ok(influencerService.getInfluencerById(id));
    }

    @GetMapping
    public ResponseEntity<List<Influencer>> getAllInfluencers() {
        return ResponseEntity.ok(influencerService.getAllInfluencers());
    }
}
