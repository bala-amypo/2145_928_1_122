package com.example.demo.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.RoiReport;

@Repository
public class RoiReportRepository {

    private Map<Long, RoiReport> map = new HashMap<>();

    public RoiReport save(RoiReport r) {
        map.put(r.getId(), r);
        return r;
    }

    public Optional<RoiReport> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }
}
