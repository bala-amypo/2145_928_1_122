// package com.example.demo.controller;

// import java.util.List;

// import jakarta.validation.Valid;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.RoiReport;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.service.RoiService;

// @RestController
// @RequestMapping("/api/roi")
// public class RoiReportController {

//     private final RoiService service;

//     public RoiReportController(RoiService service) {
//         this.service = service;
//     }

//     @PostMapping("/add")
//     public ResponseEntity<RoiReport> add(
//             @Valid @RequestBody RoiReport r) {

//         return ResponseEntity.ok(service.insertReport(r));
//     }

//     @GetMapping("/get/{id}")
//     public ResponseEntity<RoiReport> get(@PathVariable Long id) {

//         RoiReport report = service.getReportById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("ROI report not found"));

//         return ResponseEntity.ok(report);
//     }

//     @GetMapping("/campaign/{campaignId}")
//     public ResponseEntity<List<RoiReport>> getByCampaign(
//             @PathVariable Long campaignId) {

//         return ResponseEntity.ok(service.getReportsByCampaign(campaignId));
//     }
// }
package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RoiReport;
import com.example.demo.service.RoiService;

@RestController
@RequestMapping("/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    @PostMapping("/code/{id}")
    public RoiReport generate(@PathVariable Long id) {
        return roiService.generateReportForCode(id);
    }

    @GetMapping("/{id}")
    public RoiReport get(@PathVariable Long id) {
        return roiService.getReportById(id);
    }

    @GetMapping("/influencer/{id}")
    public List<RoiReport> byInfluencer(@PathVariable Long id) {
        return roiService.getReportsForInfluencer(id);
    }
}
