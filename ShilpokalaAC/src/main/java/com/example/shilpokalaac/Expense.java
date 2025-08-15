package com.example.project_by_pushon;

public class Expense {

    private String expenseId;
    private String submittedBy;
    private String description;
    private double amount;
    private String submissionDate;
    private String status;

    public Expense(String expenseId, String submittedBy, String description, double amount, String submissionDate, String status) {
        this.expenseId = expenseId;
        this.submittedBy = submittedBy;
        this.description = description;
        this.amount = amount;
        this.submissionDate = submissionDate;
        this.status = status;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId='" + expenseId + '\'' +
                ", submittedBy='" + submittedBy + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", submissionDate='" + submissionDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}