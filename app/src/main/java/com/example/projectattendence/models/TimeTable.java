package com.example.projectattendence.models;

public class TimeTable {
    private String slot;
    private String subject;
    private String venue;
    private String section;



    public TimeTable(String slot, String subject, String venue, String section) {
        this.slot = slot;
        this.subject = subject;
        this.venue = venue;
        this.section = section;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
