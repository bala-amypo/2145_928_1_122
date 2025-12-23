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
package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Influencer;

public interface InfluencerService {

    Influencer createInfluencer(Influencer influencer);

    List<Influencer> getAllInfluencers();

    Influencer getInfluencerById(Long id);
}
