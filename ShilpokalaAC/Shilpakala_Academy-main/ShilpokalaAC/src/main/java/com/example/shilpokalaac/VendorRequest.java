package com.example.project_by_pushon;

import java.time.LocalDate;

public class VendorRequest {

    private String vendorName;
    private String serviceType;
    private double cost;
    private String status;
    private LocalDate requestDate;

    public VendorRequest(String vendorName, String serviceType, double cost, String status, LocalDate requestDate) {
        this.vendorName = vendorName;
        this.serviceType = serviceType;
        this.cost = cost;
        this.status = status;
        this.requestDate = requestDate;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "VendorRequest{" +
                "vendorName='" + vendorName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }
}