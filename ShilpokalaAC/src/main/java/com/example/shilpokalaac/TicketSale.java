package com.example.project_by_pushon;

public class TicketSale {

    private String saleId;
    private String ticketType;
    private int quantity;
    private double pricePerTicket;
    private double totalRevenue;
    private String saleDate;

    public TicketSale(String ticketType, int quantity, double pricePerTicket, String saleDate) {
        this.saleId = "AUTO-" + System.currentTimeMillis();
        this.ticketType = ticketType;
        this.quantity = quantity;
        this.pricePerTicket = pricePerTicket;
        this.totalRevenue = quantity * pricePerTicket;
        this.saleDate = saleDate;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalRevenue = this.quantity * this.pricePerTicket;
    }

    public double getPricePerTicket() {
        return pricePerTicket;
    }

    public void setPricePerTicket(double pricePerTicket) {
        this.pricePerTicket = pricePerTicket;
        this.totalRevenue = this.quantity * this.pricePerTicket;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "TicketSale{" +
                "saleId='" + saleId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", quantity=" + quantity +
                ", pricePerTicket=" + pricePerTicket +
                ", totalRevenue=" + totalRevenue +
                ", saleDate='" + saleDate + '\'' +
                '}';
    }
}