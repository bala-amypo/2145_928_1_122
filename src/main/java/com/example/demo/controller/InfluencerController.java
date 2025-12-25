package com.example.demo.controller;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    @PostMapping
    public Influencer create(@RequestBody Influencer influencer) {
        return influencerService.createInfluencer(influencer);
    }

    @PutMapping("/{id}")
    public Influencer update(@PathVariable Long id,
                             @RequestBody Influencer influencer) {
        return influencerService.updateInfluencer(id, influencer);
    }

    @GetMapping("/{id}")
    public Influencer getById(@PathVariable Long id) {
        return influencerService.getInfluencerById(id);
    }

    @GetMapping
    public List<Influencer> getAll() {
        return influencerService.getAllInfluencers();
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        influencerService.deactivateInfluencer(id);
    }
}
