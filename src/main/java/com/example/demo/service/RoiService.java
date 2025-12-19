package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.RoiReport;

public interface RoiService {
    RoiReport insertReport(RoiReport r);
    Optional<RoiReport> getReportById(Long id);
    List<RoiReport> getReportsByCampaign(Long campaignId);
}
