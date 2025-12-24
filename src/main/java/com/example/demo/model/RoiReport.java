package com.example.demo.model;

import java.math.BigDecimal;

public class RoiReport {

    private BigDecimal totalSales;
    private int totalTransactions;
    private double roiPercentage;
    private DiscountCode discountCode;

    public RoiReport() {}

    // ✅ REQUIRED BY RoiServiceImpl
    public RoiReport(DiscountCode discountCode,
                     BigDecimal totalSales,
                     int totalTransactions,
                     double roiPercentage) {
        this.discountCode = discountCode;
        this.totalSales = totalSales;
        this.totalTransactions = totalTransactions;
        this.roiPercentage = roiPercentage;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public double getRoiPercentage() {
        return roiPercentage;
    }

    public void setRoiPercentage(double roiPercentage) {
        this.roiPercentage = roiPercentage;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }
}
