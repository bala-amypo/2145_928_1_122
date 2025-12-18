package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.Campaign;

public class CampaignRepository {
    Map<Long, Campaign> map = new HashMap<>();

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
