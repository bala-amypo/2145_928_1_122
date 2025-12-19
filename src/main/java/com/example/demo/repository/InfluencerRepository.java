package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.Influencer;

public class InfluencerRepository {
    Map<Long, Influencer> map = new HashMap<>();

    public Influencer save(Influencer i) {
        map.put(i.getId(), i);
        return i;
    }

    public Optional<Influencer> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public Optional<Influencer> findBySocialHandle(String handle) {
        for (Influencer i : map.values()) {
            if (i.getSocialHandle().equals(handle)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public List<Influencer> findAll() {
        return new ArrayList<>(map.values());
    }
}
