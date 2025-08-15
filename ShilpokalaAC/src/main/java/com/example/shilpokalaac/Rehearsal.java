package com.example.project_by_pushon;

import java.time.LocalDate;

public class Rehearsal {


    private String rehearsalName;
    private LocalDate date;
    private String time;
    private String location;


    public Rehearsal(String rehearsalName, LocalDate date, String time, String location) {
        this.rehearsalName = rehearsalName;
        this.date = date;
        this.time = time;
        this.location = location;
    }


    public String getRehearsalName() {
        return rehearsalName;
    }

    public void setRehearsalName(String rehearsalName) {
        this.rehearsalName = rehearsalName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Rehearsal{" +
                "rehearsalName='" + rehearsalName + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}