package com.example.projectattendence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projectattendence.adapter.StdDetailAdp;
import com.example.projectattendence.api.RetrofitClient;
import com.example.projectattendence.models.StdEnrolledCoursesinfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Student1 extends AppCompatActivity {
    RecyclerView StdDetailRecyclerView;
    StdDetailAdp AtdDetailadapter;
    StdEnrolledCoursesinfo object ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student1);

        TextView name=findViewById(R.id.StudentName);
        TextView regno=findViewById(R.id.StudentRegno);

        // Getting username from login activity
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String UserName = b.getString("userName");

        // Enrolled Courses of Student
        StdDetailRecyclerView = findViewById(R.id.StudentRecycler);

        RetrofitClient client = RetrofitClient.getInstance();
        client.getMyApi().GetStudentEnrolledCourse(UserName).
                enqueue(new Callback<List<StdEnrolledCoursesinfo>>() {
                    @Override
                    public void onResponse(Call<List<StdEnrolledCoursesinfo>> call, Response<List<StdEnrolledCoursesinfo>> response) {
                        if(response.isSuccessful()) {
                            AtdDetailadapter = new StdDetailAdp(response.body(),Student1.this);
                            StdDetailRecyclerView.setLayoutManager(new LinearLayoutManager(Student1.this));
                            StdDetailRecyclerView.setAdapter(AtdDetailadapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<StdEnrolledCoursesinfo>> call, Throwable t) {

                    }
                });
    }
    //Passing Subject name to second screen
    public void cellClicked(StdEnrolledCoursesinfo objCourse) {
        Intent intent = new Intent(this, Std_Atd_review.class);
        Bundle b = new Bundle();
        b.putString("subject", objCourse.C_Name);
        b.putString("UserName",objCourse.StudentName);

        intent.putExtras(b);
        startActivity(intent);
    }
}