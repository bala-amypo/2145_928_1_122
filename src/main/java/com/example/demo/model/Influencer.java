package com.example.demo.model;

@Entity
public class Influencer {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String socialHandle;
    private String email;
    private Boolean active = true;

}
