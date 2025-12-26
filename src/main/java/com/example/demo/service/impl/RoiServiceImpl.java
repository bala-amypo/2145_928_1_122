package com.example.demo.service.impl;

import com.example.demo.model.RoiReport;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.RoiReportRepository;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    private final SaleTransactionRepository saleTransactionRepository;
    private final RoiReportRepository roiReportRepository;

    public RoiServiceImpl(SaleTransactionRepository saleTransactionRepository,
                          RoiReportRepository roiReportRepository) {
        this.saleTransactionRepository = saleTransactionRepository;
        this.roiReportRepository = roiReportRepository;
    }

    @Override
    public RoiReport generateReportForCode(Long discountCodeId) {

        List<SaleTransaction> transactions =
                saleTransactionRepository.findByDiscountCode_Id(discountCodeId);

        BigDecimal totalSales = BigDecimal.ZERO;

        for (SaleTransaction tx : transactions) {
            totalSales = totalSales.add(tx.getTransactionAmount());
        }

        RoiReport report = new RoiReport();
        report.setTotalSales(totalSales);
        report.setTotalRevenue(totalSales);
        report.setTotalTransactions(transactions.size());
        report.setRoiPercentage(transactions.isEmpty() ? 0.0 : 100.0);
        report.setGeneratedAt(LocalDateTime.now());

        if (!transactions.isEmpty()) {
            report.setDiscountCode(transactions.get(0).getDiscountCode());
        }

        return roiReportRepository.save(report);
    }

    @Override
    public List<RoiReport> generateReportForInfluencer(Long influencerId) {
        return roiReportRepository.findByDiscountCode_Influencer_Id(influencerId);
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByDiscountCode_Influencer_Id(influencerId);
    }

    @Override
    public RoiReport getReportById(Long reportId) {
        return roiReportRepository.findById(reportId).orElse(null);
    }
}
