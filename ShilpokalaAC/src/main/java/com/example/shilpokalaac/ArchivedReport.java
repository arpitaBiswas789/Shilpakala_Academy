package com.example.project_by_pushon;

public class ArchivedReport {

    private String reportName;
    private String dateArchived;
    private String size;

    public ArchivedReport(String reportName, String dateArchived, String size) {
        this.reportName = reportName;
        this.dateArchived = dateArchived;
        this.size = size;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getDateArchived() {
        return dateArchived;
    }

    public void setDateArchived(String dateArchived) {
        this.dateArchived = dateArchived;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ArchivedReport{" +
                "reportName='" + reportName + '\'' +
                ", dateArchived='" + dateArchived + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}