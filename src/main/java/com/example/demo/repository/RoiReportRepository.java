

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RoiReport;

public interface RoiReportRepository extends JpaRepository<RoiReport, Long> {
    List<RoiReport> findByCampaign_Id(Long campaignId);
}


