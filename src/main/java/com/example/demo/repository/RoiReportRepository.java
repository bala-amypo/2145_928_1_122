package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.RoiReport;

public class RoiReportRepository {
    Map<Long, RoiReport> map = new HashMap<>();

    public RoiReport save(RoiReport r) {
        map.put(r.getId(), r);
        return r;
    }

    public Optional<RoiReport> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public List<RoiReport> findByCampaign_Id(Long campaignId) {
        return new ArrayList<>(map.values());
    }
}
