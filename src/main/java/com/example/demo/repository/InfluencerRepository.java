

package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Influencer;

public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
    Influencer findBySocialHandle(String handle);
}

