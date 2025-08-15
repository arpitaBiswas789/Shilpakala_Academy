package com.example.project_by_pushon;

public class SecurityNote {

    private String timestamp;
    private String author;
    private String note;
    private String priority;

    public SecurityNote(String timestamp, String author, String note, String priority) {
        this.timestamp = timestamp;
        this.author = author;
        this.note = note;
        this.priority = priority;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "SecurityNote{" +
                "timestamp='" + timestamp + '\'' +
                ", author='" + author + '\'' +
                ", note='" + note + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}