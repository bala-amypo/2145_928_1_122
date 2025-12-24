package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;

@RestController
@RequestMapping("/api/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    // 🔥 TEST EXPECTS THIS METHOD NAME
    @PostMapping("/code/{discountCodeId}")
    public ResponseEntity<RoiReport> generateRoiReport(
            @PathVariable Long discountCodeId) {

        return ResponseEntity.ok(
                roiService.generateReportForCode(discountCodeId)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoiReport> getRoiReport(@PathVariable Long id) {
        return ResponseEntity.ok(
                roiService.getReportById(id)
        );
    }

    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<RoiReport>> getRoiReportsByInfluencer(
            @PathVariable Long influencerId) {

        return ResponseEntity.ok(
                roiService.getReportsForInfluencer(influencerId)
        );
    }
}
