package com.example.demo.model;

import java.math.BigDecimal;

public class RoiReport {

    private DiscountCode discountCode;
    private BigDecimal totalRevenue;
    private int totalSales;
    private double roiPercentage;

    public RoiReport(DiscountCode discountCode,
                     BigDecimal totalRevenue,
                     int totalSales,
                     double roiPercentage) {
        this.discountCode = discountCode;
        this.totalRevenue = totalRevenue;
        this.totalSales = totalSales;
        this.roiPercentage = roiPercentage;
    }

    // ✅ No-args constructor (safety)
    public RoiReport() {}

    public DiscountCode getDiscountCode() { return discountCode; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public int getTotalSales() { return totalSales; }
    public double getRoiPercentage() { return roiPercentage; }
}
