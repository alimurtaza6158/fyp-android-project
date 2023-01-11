package com.example.projectattendence.models;

public class EnrolledCourseofChild {
    private String Course,AtdPercentage;

    public EnrolledCourseofChild(String course, String atdPercentage) {
        Course = course;
        AtdPercentage = atdPercentage;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getAtdPercentage() {
        return AtdPercentage;
    }

    public void setAtdPercentage(String atdPercentage) {
        AtdPercentage = atdPercentage;
    }
}
