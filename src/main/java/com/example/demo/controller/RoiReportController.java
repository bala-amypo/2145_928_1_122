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

    // 🔹 Accept STRING → convert to Long (TEST FIX)
    @PostMapping("/code/{codeId}")
    public RoiReport generateForCode(@PathVariable String codeId) {
        return roiService.generateReportForCode(Long.valueOf(codeId));
    }

    // 🔹 Accept STRING → convert to Long (TEST FIX)
    @GetMapping("/influencer/{influencerId}")
    public List<RoiReport> getForInfluencer(@PathVariable String influencerId) {
        return roiService.getReportsForInfluencer(Long.valueOf(influencerId));
    }

    // 🔹 Accept STRING → convert to Long (TEST FIX)
    @GetMapping("/{id}")
    public RoiReport getById(@PathVariable String id) {
        return roiService.getReportById(Long.valueOf(id));
    }
}
