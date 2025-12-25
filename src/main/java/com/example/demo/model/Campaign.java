package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String campaignName;

    private Date startDate;
    private Date endDate;

    private BigDecimal budget;

    private Boolean active = true;

    // ✅ GETTERS & SETTERS
    public Long getId() { return id; }

    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }
}
