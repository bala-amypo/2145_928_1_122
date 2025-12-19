package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Campaign;
import com.example.demo.service.CampaignService;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    @Autowired
    CampaignService service;

    @PostMapping("/add")
    public Campaign add(@RequestBody Campaign c) {
        return service.insertCampaign(c);
    }

    @GetMapping("/getAll")
    public List<Campaign> getAll() {
        return service.getAllCampaigns();
    }

    @GetMapping("/get/{id}")
    public Optional<Campaign> get(@PathVariable Long id) {
        return service.getCampaignById(id);
    }

    @PutMapping("/deactivate/{id}")
    public String deactivate(@PathVariable Long id) {
        service.deactivateCampaign(id);
        return "Deactivated";
    }
}
