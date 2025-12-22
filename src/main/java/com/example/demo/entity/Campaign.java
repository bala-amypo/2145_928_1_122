package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String campaignName;
    private Date startDate;
    private Date endDate;
    private BigDecimal budget;
    private Boolean active = true;

    // getters & setters
}
