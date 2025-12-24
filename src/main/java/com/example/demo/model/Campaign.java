package com.example.demo.model;

import java.time.LocalDateTime;

@Entity
public class Campaign {
    @Id @GeneratedValue
    private Long id;
    private String campaignName;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal budget;
    private Boolean active = true;

    // getters + setters
}

