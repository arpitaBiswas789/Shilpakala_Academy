package com.example.project_by_pushon;

public class Invoice {

    private String invoiceId;
    private String vendorName;
    private double amountDue;
    private String dueDate;
    private String status;

    public Invoice(String invoiceId, String vendorName, double amountDue, String dueDate, String status) {
        this.invoiceId = invoiceId;
        this.vendorName = vendorName;
        this.amountDue = amountDue;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", amountDue=" + amountDue +
                ", dueDate='" + dueDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}