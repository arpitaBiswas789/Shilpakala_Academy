package com.example.project_by_pushon;

public class SalaryDisbursement {

    private String employeeId;
    private String employeeName;
    private double amount;
    private String paymentDate;
    private String status;
    private double hourlyRate;
    private int workHours;

    public SalaryDisbursement(String employeeId, String employeeName, double hourlyRate, int workHours, String status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
        this.amount = hourlyRate * workHours;
        this.paymentDate = java.time.LocalDate.now().toString();
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
        this.amount = hourlyRate * workHours;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
        this.amount = hourlyRate * workHours;
    }

    @Override
    public String toString() {
        return "SalaryDisbursement{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", amount=" + amount +
                ", paymentDate='" + paymentDate + '\'' +
                ", status='" + status + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", workHours=" + workHours +
                '}';
    }
}