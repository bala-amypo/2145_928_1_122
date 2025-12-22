package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String socialHandle;
    private String email;
    private Boolean active = true;

    // getters & setters
}
