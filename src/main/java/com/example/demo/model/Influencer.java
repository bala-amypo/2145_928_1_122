package com.example.demo.model;

public class Influencer {

    private Long id;
    private String name;

    public Influencer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {          // REQUIRED BY TEST
        return name;
    }

    public void setName(String name) { // REQUIRED BY TEST
        this.name = name;
    }
}
