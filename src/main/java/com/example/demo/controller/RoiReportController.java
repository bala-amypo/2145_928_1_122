package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    @PostMapping("/influencer/{influencerId}")
    public RoiReport generate(@PathVariable Long influencerId) {
        return roiService.generateReportForInfluencer(influencerId);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<RoiReport> getForInfluencer(
            @PathVariable Long influencerId) {
        return roiService.getReportsForInfluencer(influencerId);
    }
}
