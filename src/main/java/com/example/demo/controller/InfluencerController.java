package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Influencer;
import com.example.demo.service.InfluencerService;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    @Autowired
    InfluencerService service;

    @PostMapping("/add")
    public Influencer add(@RequestBody Influencer i) {
        return service.insertInfluencer(i);
    }

    @GetMapping("/getAll")
    public List<Influencer> getAll() {
        return service.getAllInfluencers();
    }

    @GetMapping("/get/{id}")
    public Optional<Influencer> get(@PathVariable Long id) {
        return service.getInfluencerById(id);
    }

    @PutMapping("/deactivate/{id}")
    public String deactivate(@PathVariable Long id) {
        service.deactivateInfluencer(id);
        return "Deactivated";
    }
}
