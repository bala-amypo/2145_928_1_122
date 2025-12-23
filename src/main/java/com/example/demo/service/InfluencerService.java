// package com.example.demo.service;

// import java.util.List;
// import java.util.Optional;
// import com.example.demo.entity.Influencer;

// public interface InfluencerService {
//     Influencer insertInfluencer(Influencer i);
//     List<Influencer> getAllInfluencers();
//     Optional<Influencer> getInfluencerById(Long id);
//     void deactivateInfluencer(Long id);
// }
package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Influencer;

public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
    Optional<Influencer> findBySocialHandle(String socialHandle);
}
