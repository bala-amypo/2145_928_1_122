package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalSales;
    private BigDecimal totalRevenue;
    private BigDecimal roiPercentage;
    private Integer totalTransactions;

    // ---------- getters & setters ----------

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    // 🔹 Accept BigDecimal
    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    // 🔹 Accept double (TEST USES DOUBLE)
    public void setTotalSales(double totalSales) {
        this.totalSales = BigDecimal.valueOf(totalSales);
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public BigDecimal getRoiPercentage() {
        return roiPercentage;
    }

    public void setRoiPercentage(BigDecimal roiPercentage) {
        this.roiPercentage = roiPercentage;
    }

    public Integer getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(Integer totalTransactions) {
        this.totalTransactions = totalTransactions;
    }
}
