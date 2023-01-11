package com.example.projectattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Enrollment extends AppCompatActivity {
    public Button AddNewStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enrollment);
        AddNewStd= findViewById(R.id.Addbtn);
        AddNewStd.setOnClickListener(v -> {
            Intent intent= new Intent(Enrollment.this,AddNewStd.class);
            startActivity(intent);
        });


    }
}