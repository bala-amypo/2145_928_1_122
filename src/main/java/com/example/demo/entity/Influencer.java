package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String socialHandle;
    private String email;
    private Boolean active = true;

    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @OneToMany(mappedBy = "influencer")
    private List<DiscountCode> discountCodes;

    @OneToMany(mappedBy = "influencer")
    private List<RoiReport> roiReports;

    // getters & setters
}
