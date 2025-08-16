package com.example.project_by_pushon;

public class Resource {

    private String resourceName;
    private int quantity;
    private String status;
    private String assignedTo;

    public Resource(String resourceName, int quantity, String status, String assignedTo) {
        this.resourceName = resourceName;
        this.quantity = quantity;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceName='" + resourceName + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                '}';
    }
}