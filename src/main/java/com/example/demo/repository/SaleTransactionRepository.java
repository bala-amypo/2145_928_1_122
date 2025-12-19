package com.example.demo.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.SaleTransaction;

@Repository
public class SaleTransactionRepository {

    private Map<Long, SaleTransaction> map = new HashMap<>();

    public SaleTransaction save(SaleTransaction s) {
        map.put(s.getId(), s);
        return s;
    }

    public Optional<SaleTransaction> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }
}
