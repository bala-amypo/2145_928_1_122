package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.SaleTransaction;

@Repository
public class SaleTransactionRepository {

    private Map<Long, SaleTransaction> map = new HashMap<>();

    public SaleTransaction save(SaleTransaction s) {
        map.put(s.getId(), s);
        return s;
    }

    public SaleTransaction findById(Long id) {
        return map.get(id);
    }

    // ✅ REQUIRED BY SaleTransactionServiceImpl
    public List<SaleTransaction> findByDiscountCode_Id(Long codeId) {
        List<SaleTransaction> list = new ArrayList<>();
        for (SaleTransaction s : map.values()) {
            if (s.getDiscountCode() != null &&
                s.getDiscountCode().getId().equals(codeId)) {
                list.add(s);
            }
        }
        return list;
    }
}
