package com.example.project_by_pushon;

public class GroundStatus {

    private String area;
    private int staffCount;

    public GroundStatus(String area, int staffCount) {
        this.area = area;
        this.staffCount = staffCount;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(int staffCount) {
        this.staffCount = staffCount;
    }

    @Override
    public String toString() {
        return "GroundStatus{" +
                "area='" + area + '\'' +
                ", staffCount=" + staffCount +
                '}';
    }
}