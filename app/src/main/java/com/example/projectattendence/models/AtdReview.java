package com.example.projectattendence.models;

public class AtdReview{
        private String Date;
        private String Day;
        private String Status;
        private String Slot;

    public AtdReview(String date, String day, String status, String slot) {
        Date = date;
        Day = day;
        Status = status;
        Slot = slot;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getSlot() {
        return Slot;
    }

    public void setSlot(String slot) {
        Slot = slot;
    }
}
