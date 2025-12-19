package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.DiscountCode;

public class DiscountCodeRepository {
    Map<Long, DiscountCode> map = new HashMap<>();

    public DiscountCode save(DiscountCode d) {
        map.put(d.getId(), d);
        return d;
    }

    public Optional<DiscountCode> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public Optional<DiscountCode> findByCode(String code) {
        for (DiscountCode d : map.values()) {
            if (d.getCode().equals(code)) {
                return Optional.of(d);
            }
        }
        return Optional.empty();
    }

    public List<DiscountCode> findAll() {
        return new ArrayList<>(map.values());
    }
}
