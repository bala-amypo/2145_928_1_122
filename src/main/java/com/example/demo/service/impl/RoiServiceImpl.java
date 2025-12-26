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

    // 🔹 STRING → LONG (TEST FIX)
    @Override
    public RoiReport generateReportForCode(String discountCodeId) {

        Long codeId = Long.valueOf(discountCodeId);

        DiscountCode code = discountCodeRepository.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        List<SaleTransaction> sales =
                saleTransactionRepository.findByDiscountCode_Id(codeId);

        BigDecimal totalSales = BigDecimal.ZERO;
        int totalTransactions = 0;

        for (SaleTransaction tx : sales) {
            totalSales = totalSales.add(tx.getTransactionAmount());
            totalTransactions++;
        }

        double roiPercentage =
                totalTransactions == 0 ? 0.0 : totalSales.doubleValue() / totalTransactions;

        RoiReport report = new RoiReport();
        report.setDiscountCode(code);
        report.setTotalSales(totalSales);
        report.setTotalRevenue(totalSales);
        report.setTotalTransactions(totalTransactions);
        report.setRoiPercentage(roiPercentage);

        return roiReportRepository.save(report);
    }

    @Override
    public RoiReport getReportById(String reportId) {
        return roiReportRepository.findById(Long.valueOf(reportId))
                .orElseThrow(() -> new RuntimeException("ROI report not found"));
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(String influencerId) {
        return roiReportRepository
                .findByDiscountCodeInfluencerId(Long.valueOf(influencerId));
    }
}
