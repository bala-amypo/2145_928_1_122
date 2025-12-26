package com.example.demo.service;

import com.example.demo.model.RoiReport;
import java.util.List;

public interface RoiService {

    RoiReport generateReportForCode(Long discountCodeId);

    List<RoiReport> generateReportForInfluencer(Long influencerId);

    List<RoiReport> getReportsForInfluencer(Long influencerId);

    RoiReport getReportById(Long reportId);
}
