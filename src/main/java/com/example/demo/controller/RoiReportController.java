package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RoiReport;
import com.example.demo.service.RoiService;

@RestController
@RequestMapping("/api/roi")
public class RoiReportController {

    private final RoiService service;

    public RoiReportController(RoiService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<RoiReport> add(
            @Valid @RequestBody RoiReport r) {
        return ResponseEntity.ok(service.insertReport(r));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RoiReport> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getReportById(id)
                .orElseThrow(() -> new RuntimeException("ROI report not found")));
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<RoiReport>> getByCampaign(
            @PathVariable Long campaignId) {
        return ResponseEntity.ok(service.getReportsByCampaign(campaignId));
    }
}
