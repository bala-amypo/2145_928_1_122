package com.example.demo.model;

public class Influencer {

    private Long id;
    private String name;
    private String socialHandle; // ✅ REQUIRED

    public Influencer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialHandle() {   // ✅ REQUIRED
        return socialHandle;
    }

    public void setSocialHandle(String socialHandle) {
        this.socialHandle = socialHandle;
    }
}
