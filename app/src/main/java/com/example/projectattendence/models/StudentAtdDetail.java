package com.example.projectattendence.models;

public class StudentAtdDetail {
    private String Subject;
    private String Percentage;

    public StudentAtdDetail(String subject, String percentage) {
        Subject = subject;
        Percentage = percentage;
    }



    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getPercentage() {
        return Percentage;
    }

    public void setPercentage(String percentage) {
        Percentage = percentage;
    }
}
