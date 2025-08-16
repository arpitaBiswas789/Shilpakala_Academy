package com.example.project_by_pushon;

public class FinancialReport {

    private String reportId;
    private String reportPeriod;
    private double totalRevenue;
    private double totalExpenses;
    private double netProfit;

    public FinancialReport(String reportId, String reportPeriod, double totalRevenue, double totalExpenses) {
        this.reportId = reportId;
        this.reportPeriod = reportPeriod;
        this.totalRevenue = totalRevenue;
        this.totalExpenses = totalExpenses;
        this.netProfit = totalRevenue - totalExpenses;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportPeriod() {
        return reportPeriod;
    }

    public void setReportPeriod(String reportPeriod) {
        this.reportPeriod = reportPeriod;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
        this.netProfit = this.totalRevenue - this.totalExpenses;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
        this.netProfit = this.totalRevenue - this.totalExpenses;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    @Override
    public String toString() {
        return "FinancialReport{" +
                "reportId='" + reportId + '\'' +
                ", reportPeriod='" + reportPeriod + '\'' +
                ", totalRevenue=" + totalRevenue +
                ", totalExpenses=" + totalExpenses +
                ", netProfit=" + netProfit +
                '}';
    }
}