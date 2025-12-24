// package com.example.demo.service;

// import java.util.List;
// import java.util.Optional;
// import com.example.demo.entity.DiscountCode;

// public interface DiscountCodeService {
//     DiscountCode insertCode(DiscountCode d);
//     Optional<DiscountCode> getCodeById(Long id);
//     List<DiscountCode> getAllCodes();
//     void deactivateCode(Long id);
// }
package com.example.demo.service;

import java.util.List;
import com.example.demo.model.DiscountCode;

public interface DiscountCodeService {

    DiscountCode getDiscountCodeById(Long id);

    DiscountCode updateDiscountCode(Long id, DiscountCode updated);

    List<DiscountCode> getCodesForInfluencer(Long influencerId);

    List<DiscountCode> getCodesForCampaign(Long campaignId);
}
