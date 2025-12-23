// package com.example.demo.service.impl;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.RoiReport;
// import com.example.demo.repository.RoiReportRepository;
// import com.example.demo.service.RoiService;

// @Service
// public class RoiServiceImpl implements RoiService {

//     @Autowired
//     RoiReportRepository repo;

//     public RoiReport insertReport(RoiReport r) {
//         return repo.save(r);
//     }

//     public Optional<RoiReport> getReportById(Long id) {
//         return repo.findById(id);
//     }

//     public List<RoiReport> getReportsByCampaign(Long campaignId) {
//         return repo.findByCampaign_Id(campaignId);
//     }
// }package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DiscountCode;
import com.example.demo.model.RoiReport;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.RoiService;

@Service
public class RoiServiceImpl implements RoiService {

    private final RoiReportRepository roiReportRepository;
    private final SaleTransactionRepository saleTransactionRepository;
    private final DiscountCodeRepository discountCodeRepository;

    public RoiServiceImpl(RoiReportRepository roiReportRepository,
                          SaleTransactionRepository saleTransactionRepository,
                          DiscountCodeRepository discountCodeRepository) {
        this.roiReportRepository = roiReportRepository;
        this.saleTransactionRepository = saleTransactionRepository;
        this.discountCodeRepository = discountCodeRepository;
    }

    /**
     * ACID:
     * If ROI calculation or save fails → rollback
     */
    @Override
    @Transactional
    public RoiReport generateReportForCode(Long discountCodeId) {

        DiscountCode code = discountCodeRepository.findById(discountCodeId)
                .orElseThrow(() -> new ResourceNotFoundException("Discount code not found"));

        List<SaleTransaction> sales =
                saleTransactionRepository.findByDiscountCodeId(discountCodeId);

        BigDecimal totalSales = BigDecimal.ZERO;
        for (SaleTransaction sale : sales) {
            totalSales = totalSales.add(sale.getTransactionAmount());
        }

        RoiReport report = new RoiReport(
                code,
                totalSales,
                sales.size(),
                totalSales.doubleValue()
        );

        return roiReportRepository.save(report);
    }

    @Override
    public RoiReport getReportById(Long reportId) {
        return roiReportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("ROI report not found"));
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByDiscountCodeInfluencerId(influencerId);
    }
}
