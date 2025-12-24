package com.example.demo.model;

@Entity
public class DiscountCode {
    @Id @GeneratedValue
    private Long id;
    private String code;
    private Double discountPercentage;
    private Boolean active = true;

    @ManyToOne
    private Influencer influencer;

    @ManyToOne
    private Campaign campaign;

}

