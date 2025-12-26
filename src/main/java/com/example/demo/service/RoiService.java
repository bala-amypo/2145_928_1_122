package com.example.demo.service;

import com.example.demo.model.RoiReport;
import java.util.List;

public interface RoiService {

    RoiReport generateReportForInfluencer(Long influencerId);

    List<RoiReport> getReportsForInfluencer(Long influencerId);
}
