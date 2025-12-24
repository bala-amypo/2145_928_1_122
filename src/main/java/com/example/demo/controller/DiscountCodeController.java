// package com.example.demo.controller;

// import java.util.List;

// import jakarta.validation.Valid;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.DiscountCode;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.service.DiscountCodeService;

// @RestController
// @RequestMapping("/api/discount-codes")
// public class DiscountCodeController {

//     private final DiscountCodeService service;

//     public DiscountCodeController(DiscountCodeService service) {
//         this.service = service;
//     }

//     @PostMapping("/add")
//     public ResponseEntity<DiscountCode> add(
//             @Valid @RequestBody DiscountCode d) {

//         return ResponseEntity.ok(service.insertCode(d));
//     }

//     @GetMapping("/getAll")
//     public ResponseEntity<List<DiscountCode>> getAll() {
//         return ResponseEntity.ok(service.getAllCodes());
//     }

//     @GetMapping("/get/{id}")
//     public ResponseEntity<DiscountCode> get(@PathVariable Long id) {

//         DiscountCode code = service.getCodeById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

//         return ResponseEntity.ok(code);
//     }

//     @PutMapping("/deactivate/{id}")
//     public ResponseEntity<String> deactivate(@PathVariable Long id) {

//         service.deactivateCode(id);
//         return ResponseEntity.ok("Discount code deactivated");
//     }
// }
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DiscountCode;
import com.example.demo.service.DiscountCodeService;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @GetMapping("/{id}")
    public DiscountCode get(@PathVariable Long id) {
        return discountCodeService.getDiscountCodeById(id);
    }

    @PutMapping("/{id}")
    public DiscountCode update(@PathVariable Long id,
                               @RequestBody DiscountCode code) {
        return discountCodeService.updateDiscountCode(id, code);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<DiscountCode> byInfluencer(@PathVariable Long influencerId) {
        return discountCodeService.getCodesForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<DiscountCode> byCampaign(@PathVariable Long campaignId) {
        return discountCodeService.getCodesForCampaign(campaignId);
    }
}
