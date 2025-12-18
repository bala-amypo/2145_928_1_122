package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.SaleTransaction;

public class SaleTransactionRepository {
    Map<Long, SaleTransaction> map = new HashMap<>();

    public SaleTransaction save(SaleTransaction s) {
        map.put(s.getId(), s);
        return s;
    }

    public Optional<SaleTransaction> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public List<SaleTransaction> findByDiscountCode_Id(Long codeId) {
        List<SaleTransaction> list = new ArrayList<>();
        for (SaleTransaction s : map.values()) {
            if (s.getDiscountCode().getId().equals(codeId)) {
                list.add(s);
            }
        }
        return list;
    }
}
