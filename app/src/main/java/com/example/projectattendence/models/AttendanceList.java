package com.example.projectattendence.models;

public class AttendanceList {
    private String Username;
    private String Regno;
    private String AttendancePer;

    public AttendanceList(String Username, String Regno, String attendancePer) {
        this.Username = Username;
        this.Regno = Regno;
        this.AttendancePer = attendancePer;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getRegno() {
        return Regno;
    }

    public void setRegno(String regno) {
        Regno = regno;
    }

    public String getAttendancePer() {
        return AttendancePer;
    }

    public void setAttendancePer(String attendancePer) {
        AttendancePer = attendancePer;
    }
}
