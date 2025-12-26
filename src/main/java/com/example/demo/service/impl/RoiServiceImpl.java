// package com.example.demo.service.impl;

// import com.example.demo.model.RoiReport;
// import com.example.demo.model.SaleTransaction;
// import com.example.demo.repository.RoiReportRepository;
// import com.example.demo.repository.SaleTransactionRepository;
// import com.example.demo.service.RoiService;
// import org.springframework.stereotype.Service;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class RoiServiceImpl implements RoiService {

//     private final SaleTransactionRepository saleTransactionRepository;
//     private final RoiReportRepository roiReportRepository;

//     public RoiServiceImpl(SaleTransactionRepository saleTransactionRepository,
//                           RoiReportRepository roiReportRepository) {
//         this.saleTransactionRepository = saleTransactionRepository;
//         this.roiReportRepository = roiReportRepository;
//     }


//     @Override
//     public RoiReport generateReportForCode(String discountCodeId) {

//         Long codeId = Long.parseLong(discountCodeId);

//         List<SaleTransaction> transactions =
//                 saleTransactionRepository.findByDiscountCode_Id(codeId);

//         BigDecimal totalSales = BigDecimal.ZERO;

//         for (SaleTransaction tx : transactions) {
//             totalSales = totalSales.add(tx.getTransactionAmount());
//         }

//         RoiReport report = new RoiReport();
//         report.setTotalSales(totalSales);
//         report.setTotalRevenue(totalSales);
//         report.setTotalTransactions(transactions.size());
//         report.setRoiPercentage(
//                 transactions.isEmpty()
//                         ? BigDecimal.ZERO
//                         : BigDecimal.valueOf(100)
//         );
//         report.setGeneratedAt(LocalDateTime.now());

//         if (!transactions.isEmpty()) {
//             report.setDiscountCode(transactions.get(0).getDiscountCode());
//         }

//         return roiReportRepository.save(report);
//     }


//     @Override
//     public List<RoiReport> getReportsForInfluencer(String influencerId) {
//         Long infId = Long.parseLong(influencerId);
//         return roiReportRepository.findByDiscountCode_Influencer_Id(infId);
//     }


//     @Override
//     public RoiReport getReportById(String reportId) {
//         Long id = Long.parseLong(reportId);
//         return roiReportRepository.findById(id).orElse(null);
//     }
// }
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

    private final SaleTransactionRepository saleRepo;
    private final RoiReportRepository roiRepo;

    public RoiServiceImpl(SaleTransactionRepository saleRepo,
                          RoiReportRepository roiRepo) {
        this.saleRepo = saleRepo;
        this.roiRepo = roiRepo;
    }

    @Override
    public RoiReport generateReportForCode(Long codeId) {

        List<SaleTransaction> txs = saleRepo.findByDiscountCode_Id(codeId);

        BigDecimal total = BigDecimal.ZERO;
        for (SaleTransaction tx : txs) {
            total = total.add(tx.getTransactionAmount());
        }

        RoiReport r = new RoiReport();
        r.setTotalSales(total);
        r.setTotalRevenue(total);
        r.setTotalTransactions(txs.size());
        r.setRoiPercentage(txs.isEmpty() ? 0.0 : 100.0);
        r.setGeneratedAt(LocalDateTime.now());

        if (!txs.isEmpty()) {
            r.setDiscountCode(txs.get(0).getDiscountCode());
        }

        return roiRepo.save(r);
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiRepo.findByDiscountCode_Influencer_Id(influencerId);
    }

    @Override
    public RoiReport getReportById(Long id) {
        return roiRepo.findById(id).orElse(null);
    }
}
