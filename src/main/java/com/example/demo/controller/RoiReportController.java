package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    @PostMapping("/generate/{codeId}")
    public RoiReport generate(@PathVariable Long codeId) {
        return roiService.generateRoiForCode(codeId);
    }

    @GetMapping("/{id}")
    public RoiReport getById(@PathVariable Long id) {
        return roiService.getReportById(id);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<RoiReport> getByCampaign(@PathVariable Long campaignId) {
        return roiService.getReportsForCampaign(campaignId);
    }
}
