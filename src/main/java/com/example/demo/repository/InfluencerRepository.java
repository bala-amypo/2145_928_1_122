package com.example.demo.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Influencer;

@Repository
public class InfluencerRepository {

    private Map<Long, Influencer> map = new HashMap<>();

    public Influencer save(Influencer i) {
        map.put(i.getId(), i);
        return i;
    }

    public Optional<Influencer> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public List<Influencer> findAll() {
        return new ArrayList<>(map.values());
    }
}
