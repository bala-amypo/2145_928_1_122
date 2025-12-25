package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository repo;

    public DiscountCodeServiceImpl(DiscountCodeRepository repo) {
        this.repo = repo;
    }

    @Override
    public DiscountCode createDiscountCode(DiscountCode code) {
        return repo.save(code);
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return repo.findById(id).orElseThrow();
    }
}
