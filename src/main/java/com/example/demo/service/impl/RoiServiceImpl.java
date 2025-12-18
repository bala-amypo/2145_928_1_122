package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RoiReport;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.service.RoiService;

@Service
public class RoiServiceImpl implements RoiService {

    @Autowired
    RoiReportRepository repo;

    public RoiReport insertReport(RoiReport r) {
        return repo.save(r);
    }

    public Optional<RoiReport> getReportById(Long id) {
        return repo.findById(id);
    }

    public List<RoiReport> getReportsByCampaign(Long campaignId) {
        return repo.findByCampaign_Id(campaignId);
    }
}
