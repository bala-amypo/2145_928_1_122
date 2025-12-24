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


package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "influencers", uniqueConstraints = {
        @UniqueConstraint(columnNames = "socialHandle")
})
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String socialHandle;
    private boolean active = true;

    public Influencer() {}

    public Influencer(String name, String socialHandle) {
        this.name = name;
        this.socialHandle = socialHandle;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSocialHandle() { return socialHandle; }
    public boolean isActive() { return active; }

    public void setActive(boolean active) { this.active = active; }
}
