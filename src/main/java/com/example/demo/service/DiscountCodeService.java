package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.DiscountCode;

public interface DiscountCodeService {
    DiscountCode insertCode(DiscountCode d);
    Optional<DiscountCode> getCodeById(Long id);
    List<DiscountCode> getAllCodes();
    void deactivateCode(Long id);
}
