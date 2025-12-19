package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.RoiReport;

@Repository
public class RoiReportRepository {

    private Map<Long, RoiReport> map = new HashMap<>();

    public RoiReport save(RoiReport r) {
        map.put(r.getId(), r);
        return r;
    }

    public RoiReport findById(Long id) {
        return map.get(id);
    }

    // ✅ REQUIRED BY RoiServiceImpl
    public List<RoiReport> findByCampaign_Id(Long campaignId) {
        List<RoiReport> list = new ArrayList<>();
        for (RoiReport r : map.values()) {
            if (r.getCampaign() != null &&
                r.getCampaign().getId().equals(campaignId)) {
                list.add(r);
            }
        }
        return list;
    }
}
