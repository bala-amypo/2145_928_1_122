package com.example.demo.service;

import com.example.demo.model.DiscountCode;

public interface DiscountCodeService {

    DiscountCode createDiscountCode(DiscountCode code);

    DiscountCode getDiscountCodeById(Long id);
}
