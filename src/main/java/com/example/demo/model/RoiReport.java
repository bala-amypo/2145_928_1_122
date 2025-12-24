package com.example.demo.model;

import java.math.BigDecimal;

public class RoiReport {

    private BigDecimal totalSales;
    private int totalTransactions;
    private double roiPercentage;
    private DiscountCode discountCode;

    public RoiReport() {}

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) { // REQUIRED
        this.totalSales = totalSales;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) { // REQUIRED
        this.totalTransactions = totalTransactions;
    }

    public double getRoiPercentage() {
        return roiPercentage;
    }

    public void setRoiPercentage(double roiPercentage) { // REQUIRED
        this.roiPercentage = roiPercentage;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode discountCode) { // REQUIRED
        this.discountCode = discountCode;
    }
}
