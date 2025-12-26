package com.example.demo.service;

import com.example.demo.model.RoiReport;
import java.util.List;

public interface RoiService {

    // 🔹 TEST CALLS STRING
    RoiReport generateReportForCode(String discountCodeId);

    RoiReport getReportById(String reportId);

    List<RoiReport> getReportsForInfluencer(String influencerId);
}
