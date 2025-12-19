package com.example.demo.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.DiscountCode;

@Repository
public class DiscountCodeRepository {

    private Map<Long, DiscountCode> map = new HashMap<>();

    public DiscountCode save(DiscountCode d) {
        map.put(d.getId(), d);
        return d;
    }

    public Optional<DiscountCode> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public List<DiscountCode> findAll() {
        return new ArrayList<>(map.values());
    }
}
