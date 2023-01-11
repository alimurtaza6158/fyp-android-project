package com.example.projectattendence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectattendence.adapter.ParentAdp;
import com.example.projectattendence.adapter.ParentAdp2;
import com.example.projectattendence.models.EnrolledCourseofChild;

import java.util.ArrayList;

public class Parent2 extends AppCompatActivity {
    RecyclerView EnrolledCoursesRecyclerView;
    ParentAdp2 coursesAdapter;



    Intent intent = getIntent();
    Bundle b = intent.getExtras();
    String  Course = b.getString("course");

    TextView SelectedCourse = (TextView) findViewById(R.id.CrstoShow);
    //SelectedCourse.setText(Course);





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent2);

        EnrolledCoursesRecyclerView = findViewById(R.id.ParentSideCourseRecycler);
        ArrayList<EnrolledCourseofChild> EnrolledCourseArrayList = new ArrayList<>();

        EnrolledCourseArrayList.add(new EnrolledCourseofChild("VP","70%"));
        EnrolledCourseArrayList.add(new EnrolledCourseofChild("OOP","80%"));


        coursesAdapter = new ParentAdp2(EnrolledCourseArrayList,this);
         EnrolledCoursesRecyclerView.setAdapter( coursesAdapter);
         EnrolledCoursesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}