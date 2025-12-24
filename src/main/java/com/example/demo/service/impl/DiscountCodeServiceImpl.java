// package com.example.demo.service.impl;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.DiscountCode;
// import com.example.demo.repository.DiscountCodeRepository;
// import com.example.demo.service.DiscountCodeService;

// @Service
// public class DiscountCodeServiceImpl implements DiscountCodeService {

//     @Autowired
//     DiscountCodeRepository repo;

//     public DiscountCode insertCode(DiscountCode d) {
//         return repo.save(d);
//     }

//     public Optional<DiscountCode> getCodeById(Long id) {
//         return repo.findById(id);
//     }

//     public List<DiscountCode> getAllCodes() {
//         return repo.findAll();
//     }

//     public void deactivateCode(Long id) {
//         repo.findById(id).ifPresent(d -> d.setActive(false));
//     }
// }


package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.DiscountCodeService;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;

    public DiscountCodeServiceImpl(DiscountCodeRepository discountCodeRepository) {
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return discountCodeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode updated) {
        if (updated.getDiscountPercentage() < 0 || updated.getDiscountPercentage() > 100) {
            throw new IllegalArgumentException("percentage");
        }

        DiscountCode code = discountCodeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

        code.setCodeValue(updated.getCodeValue());
        code.setDiscountPercentage(updated.getDiscountPercentage());

        return discountCodeRepository.save(code);
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return discountCodeRepository.findByInfluencerId(influencerId);
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return discountCodeRepository.findByCampaignId(campaignId);
    }
}
