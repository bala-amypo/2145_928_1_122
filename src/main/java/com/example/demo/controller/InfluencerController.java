


package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Influencer;
import com.example.demo.service.InfluencerService;
//kill -9 132088

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    private final InfluencerService service;

    public InfluencerController(InfluencerService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Influencer> add(
            @Valid @RequestBody Influencer i) {
        return ResponseEntity.ok(service.insertInfluencer(i));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Influencer>> getAll() {
        return ResponseEntity.ok(service.getAllInfluencers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Influencer> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getInfluencerById(id)
                .orElseThrow(() -> new RuntimeException("Influencer not found")));
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id) {
        service.deactivateInfluencer(id);
        return ResponseEntity.ok("Influencer deactivated");
    }
}
