package com.example.demo.service.impl;

import com.example.demo.model.RoiReport;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository roiRepo;

    public RoiServiceImpl(RoiReportRepository roiRepo) {
        this.roiRepo = roiRepo;
    }

    @Override
    public RoiReport generateReportForInfluencer(Long influencerId) {

        RoiReport report = new RoiReport();
        report.setTotalSales(BigDecimal.ZERO);
        report.setTotalRevenue(BigDecimal.ZERO);
        report.setRoiPercentage(BigDecimal.ZERO);

        return roiRepo.save(report);
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiRepo.findByInfluencer_Id(influencerId);
    }
}
