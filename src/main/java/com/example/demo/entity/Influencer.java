package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "influencers")
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String socialHandle;

    @Column(unique = true)
    private String email;

    private Boolean active = true;

    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @OneToMany(mappedBy = "influencer")
    private List<DiscountCode> discountCodes;

    // getters & setters
}
