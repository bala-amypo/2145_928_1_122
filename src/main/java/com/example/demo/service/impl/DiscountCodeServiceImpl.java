package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.DiscountCodeService;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    @Autowired
    DiscountCodeRepository repo;

    public DiscountCode insertCode(DiscountCode d) {
        return repo.save(d);
    }

    public Optional<DiscountCode> getCodeById(Long id) {
        return repo.findById(id);
    }

    public List<DiscountCode> getAllCodes() {
        return repo.findAll();
    }

    public void deactivateCode(Long id) {
        repo.findById(id).ifPresent(d -> d.setActive(false));
    }
}
