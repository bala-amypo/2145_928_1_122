package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Campaign campaign;

    @ManyToOne
    private Influencer influencer;

    private BigDecimal totalSales;
    private BigDecimal totalRevenue;
    private BigDecimal roiPercentage;

    private LocalDateTime generatedAt;

    @PrePersist
    void onCreate() {
        generatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
}
