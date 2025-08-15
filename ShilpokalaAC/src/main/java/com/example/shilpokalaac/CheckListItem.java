package com.example.project_by_pushon;

import java.time.LocalDate;

public class CheckListItem {

    private String task;
    private String status;
    private LocalDate dueDate;
    private String assignedTo;
    private String event;

    public CheckListItem(String task, String status, LocalDate dueDate, String assignedTo, String event) {
        this.task = task;
        this.status = status;
        this.dueDate = dueDate;
        this.assignedTo = assignedTo;
        this.event = event;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "CheckListItem{" +
                "task='" + task + '\'' +
                ", status='" + status + '\'' +
                ", dueDate=" + dueDate +
                ", assignedTo='" + assignedTo + '\'' +
                ", event='" + event + '\'' +
                '}';
    }
}