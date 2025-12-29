// package com.example.demo.model;

// public class Influencer {
//     private Long id;
//     private String name;
//     private boolean active;

//     public Long getId() { return id; }
//     public String getName() { return name; }
//     public boolean isActive() { return active; }

//     public void setId(Long id) { this.id = id; }
//     public void setName(String name) { this.name = name; }
//     public void setActive(boolean active) { this.active = active; }
// }


package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "influencer")
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean active;

    // No-arg constructor (REQUIRED by JPA)
    public Influencer() {
    }

    // Getters and Setters
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
