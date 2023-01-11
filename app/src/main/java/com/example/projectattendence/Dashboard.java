package com.example.projectattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    public Button notification;
    public Button enroll;
    public Button allocate;
    public Button attendance;
    public Button slot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        notification = findViewById(R.id.notibtn);
        enroll= findViewById(R.id.enrollbtn);
        allocate = findViewById(R.id.allocatebtn);
        attendance = findViewById(R.id.attendancebtn);
        slot = findViewById(R.id.slotbtn);


        notification.setOnClickListener(v -> {
            Intent intent= new Intent(Dashboard.this,Notification.class);
            startActivity(intent);
        });
        enroll.setOnClickListener(v -> {
            Intent intent= new Intent(Dashboard.this,Enrollment.class);
            startActivity(intent);
        });
        allocate.setOnClickListener(v -> {
            Intent intent= new Intent(Dashboard.this,Allocate.class);
            startActivity(intent);
        });
        attendance.setOnClickListener(v -> {
            Intent intent= new Intent(Dashboard.this,AttendanceSystem.class);
            startActivity(intent);
        });
        slot.setOnClickListener(v -> {
            Intent intent= new Intent(Dashboard.this,SlotSetting.class);
            startActivity(intent);
        });






    }
}