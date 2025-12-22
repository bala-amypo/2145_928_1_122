package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String campaignName;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private BigDecimal budget;

    private Boolean active = true;

    @OneToMany(mappedBy = "campaign")
    private List<DiscountCode> discountCodes;

    // getters & setters
}
