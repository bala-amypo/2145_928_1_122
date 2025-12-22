package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalSales;
    private BigDecimal totalRevenue;
    private BigDecimal roiPercentage;
    private Timestamp generatedAt = new Timestamp(System.currentTimeMillis());

    @ManyToOne
    private Campaign campaign;

    @ManyToOne
    private Influencer influencer;

    // getters & setters
}
