package com.example.demo.model;

import java.math.BigDecimal;

public class RoiReport {
    private BigDecimal totalSales;
    private int totalTransactions;
    private double roiPercentage;
    private DiscountCode discountCode;

    public BigDecimal getTotalSales() { return totalSales; }
    public int getTotalTransactions() { return totalTransactions; }
    public double getRoiPercentage() { return roiPercentage; }
    public DiscountCode getDiscountCode() { return discountCode; }

    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
    public void setTotalTransactions(int totalTransactions) { this.totalTransactions = totalTransactions; }
    public void setRoiPercentage(double roiPercentage) { this.roiPercentage = roiPercentage; }
    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
}
