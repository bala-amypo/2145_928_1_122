package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Campaign;

@Repository   // ✅ REQUIRED
public class CampaignRepository {

    private Map<Long, Campaign> map = new HashMap<>();

    public Campaign save(Campaign c) {
        map.put(c.getId(), c);
        return c;
    }

    public Optional<Campaign> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public List<Campaign> findAll() {
        return new ArrayList<>(map.values());
    }
}
