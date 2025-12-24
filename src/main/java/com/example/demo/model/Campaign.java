package com.example.demo.model;

import jakarta.persistence.*;     // 🔴 REQUIRED
import java.time.LocalDate;      // 🔴 REQUIRED
import java.math.BigDecimal;     // 🔴 REQUIRED

@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;

    private String campaignName;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal budget;
    private Boolean active = true;

    // getters & setters
}
