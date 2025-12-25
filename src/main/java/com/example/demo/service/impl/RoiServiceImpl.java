package com.example.demo.service.impl;

import com.example.demo.model.RoiReport;
import com.example.demo.model.SaleTransaction;
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

    public RoiServiceImpl(RoiReportRepository roiReportRepository,
                          SaleTransactionRepository saleTransactionRepository) {
        this.roiReportRepository = roiReportRepository;
        this.saleTransactionRepository = saleTransactionRepository;
    }

    @Override
    public RoiReport generateRoiForCode(Long codeId) {
        List<SaleTransaction> sales =
                saleTransactionRepository.findByDiscountCode_Id(codeId);

        BigDecimal total = BigDecimal.ZERO;
        for (SaleTransaction s : sales) {
            total = total.add(s.getSaleAmount());
        }

        RoiReport report = new RoiReport();
        report.setTotalSales(total);
        report.setTotalRevenue(total);
        report.setRoiPercentage(BigDecimal.TEN);

        return roiReportRepository.save(report);
    }

    @Override
    public RoiReport getReportById(Long id) {
        return roiReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<RoiReport> getReportsForCampaign(Long campaignId) {
        return roiReportRepository.findByCampaign_Id(campaignId);
    }
}
