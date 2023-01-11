package com.example.projectattendence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.projectattendence.adapter.ReviewingAtdAdp;
import com.example.projectattendence.adapter.StdDetailAdp;
import com.example.projectattendence.api.RetrofitClient;
import com.example.projectattendence.models.AtdReview;
import com.example.projectattendence.models.GettingAtdInfo;
import com.example.projectattendence.models.StdEnrolledCoursesinfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Std_Atd_review extends AppCompatActivity {
    RecyclerView AtdStatusRecyclerView;
    ReviewingAtdAdp AtdStatusadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.std_atd_review);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String  subject = b.getString("subject");
        String username = b.getString("UserName");

        Toast.makeText(this, subject, Toast.LENGTH_LONG).show();

        AtdStatusRecyclerView = findViewById(R.id.AtdReviewRecycler);
        RetrofitClient client = RetrofitClient.getInstance();
        client.getMyApi().GetStudentAttendance(username,subject).
                enqueue(new Callback<List<GettingAtdInfo>>() {
                    @Override
                    public void onResponse(Call<List<GettingAtdInfo>> call, Response<List<GettingAtdInfo>> response) {
                        if (response.isSuccessful()) {
                            AtdStatusadapter = new ReviewingAtdAdp(response.body(), Std_Atd_review.this);
                            AtdStatusRecyclerView.setLayoutManager(new LinearLayoutManager(Std_Atd_review.this));
                            AtdStatusRecyclerView.setAdapter(AtdStatusadapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GettingAtdInfo>> call, Throwable t) {

                    }
                });
    }


    }
