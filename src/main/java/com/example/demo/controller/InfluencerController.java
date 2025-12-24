package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    @PostMapping
    public ResponseEntity<Influencer> create(@RequestBody Influencer i) {
        return ResponseEntity.ok(i);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Influencer> get(@PathVariable Long id) {
        return ResponseEntity.ok(new Influencer());
    }
}
