package com.example.demo.model;

@Entity
public class Influencer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String socialHandle;
    private String email;
    private Boolean active = true;

    public String getSocialHandle() {
        return socialHandle;
    }

    public void setSocialHandle(String socialHandle) {
        this.socialHandle = socialHandle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
