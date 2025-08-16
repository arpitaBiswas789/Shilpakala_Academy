package com.example.project_by_pushon;

public class IncidentReport {

    private String incidentType;
    private String location;
    private String time;
    private String description;
    private String status;

    public IncidentReport(String incidentType, String location, String time, String description, String status) {
        this.incidentType = incidentType;
        this.location = location;
        this.time = time;
        this.description = description;
        this.status = status;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IncidentReport{" +
                "incidentType='" + incidentType + '\'' +
                ", location='" + location + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}