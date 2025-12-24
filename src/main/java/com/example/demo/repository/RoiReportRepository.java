// package com.example.demo.repository;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.demo.entity.RoiReport;

// @Repository
// public interface RoiReportRepository extends JpaRepository<RoiReport, Long> {

//     List<RoiReport> findByCampaign_Id(Long campaignId);
// }

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RoiReport;

public interface RoiReportRepository extends JpaRepository<RoiReport, Long> {

    List<RoiReport> findByDiscountCodeInfluencerId(Long influencerId);
}
