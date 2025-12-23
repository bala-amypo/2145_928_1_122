// package com.example.demo.entity;

// import java.sql.Timestamp;

// import jakarta.persistence.*;

// @Entity
// public class Influencer {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private String socialHandle;

//     @Column(unique = true)
//     private String email;

//     private Boolean active = true;

//     private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

//     public Influencer() {}

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }
 
//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getSocialHandle() {
//         return socialHandle;
//     }

//     public void setSocialHandle(String socialHandle) {
//         this.socialHandle = socialHandle;
//     }

//     public String getEmail() {
//         return email;
//     }
 
//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public Boolean getActive() {
//         return active;
//     }

//     public void setActive(Boolean active) {
//         this.active = active;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "influencers")
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String socialHandle;

    private boolean active = true;

    @OneToMany(mappedBy = "influencer")
    private List<DiscountCode> discountCodes;

    public Influencer() {}

    public Influencer(String name, String socialHandle, boolean active) {
        this.name = name;
        this.socialHandle = socialHandle;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSocialHandle() { return socialHandle; }
    public boolean isActive() { return active; }

    public void setName(String name) { this.name = name; }
    public void setSocialHandle(String socialHandle) { this.socialHandle = socialHandle; }
    public void setActive(boolean active) { this.active = active; }
}
