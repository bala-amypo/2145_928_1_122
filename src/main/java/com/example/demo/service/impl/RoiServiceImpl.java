package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.model.RoiReport;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    @Override
    public RoiReport generateReportForCode(Long discountCodeId) {

        DiscountCode code = discountCodeRepository.findById(discountCodeId)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        // ✅ FIXED METHOD NAME HERE
        List<SaleTransaction> sales =
                saleTransactionRepository.findByDiscountCode_Id(discountCodeId);

        BigDecimal totalSales = BigDecimal.ZERO;
        int totalTransactions = 0;

        for (SaleTransaction tx : sales) {
            totalSales = totalSales.add(tx.getTransactionAmount());
            totalTransactions++;
        }

        double roiPercentage =
                totalTransactions == 0
                        ? 0.0
                        : totalSales.doubleValue() / totalTransactions;

        RoiReport report = new RoiReport();
        report.setDiscountCode(code);
        report.setTotalSales(totalSales);
        report.setTotalRevenue(totalSales);
        report.setTotalTransactions(totalTransactions);
        report.setRoiPercentage(roiPercentage);

        return roiReportRepository.save(report);
    }

    @Override
    public RoiReport getReportById(Long reportId) {
        return roiReportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("ROI report not found"));
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByDiscountCodeInfluencerId(influencerId);
    }

    @Override
    public List<RoiReport> generateReportForInfluencer(Long influencerId) {
        return getReportsForInfluencer(influencerId);
    }
}
