package com.example.demo.service;

import com.example.demo.model.RoiReport;

import java.util.List;

public interface RoiService {

    RoiReport generateReportForCode(String discountCodeId);

    List<RoiReport> getReportsForInfluencer(String influencerId);

    RoiReport getReportById(String reportId);
}
