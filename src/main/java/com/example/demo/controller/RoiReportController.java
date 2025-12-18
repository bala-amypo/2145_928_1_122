package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RoiReport;
import com.example.demo.service.RoiService;

@RestController
@RequestMapping("/api/roi")
public class RoiReportController {

    @Autowired
    RoiService service;

    @PostMapping("/add")
    public RoiReport add(@RequestBody RoiReport r) {
        return service.insertReport(r);
    }

    @GetMapping("/get/{id}")
    public Optional<RoiReport> get(@PathVariable Long id) {
        return service.getReportById(id);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<RoiReport> getByCampaign(@PathVariable Long campaignId) {
        return service.getReportsByCampaign(campaignId);
    }
}
