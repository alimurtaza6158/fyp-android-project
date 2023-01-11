package com.example.projectattendence.Teacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectattendence.CapturingImage;
import com.example.projectattendence.R;
import com.example.projectattendence.adapter.StudentListAdp;
import com.example.projectattendence.api.Api;
import com.example.projectattendence.api.RetrofitClient;
import com.example.projectattendence.models.AttendanceSheetinfo;
import com.example.projectattendence.models.MarkingAttendance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendanceSheet extends AppCompatActivity {
    ArrayList<AttendanceSheetinfo> slist = new ArrayList<>();
    RecyclerView AtdListRecyclerView;
    StudentListAdp Atdadapter;
    TextView SlotInAtd;
    TextView SubjectInAtd;
    TextView VenueInAtd;
    TextView SectionInAtd;
    Button ImageCapture,Submitbtn;
    String Day="";
    String Date="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendance_sheet);

        //Getting Slot,Subject,Section and Venue from teachers timetable
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String Slot = b.getString("slot");
        String Subject = b.getString("subject");
        String Section = b.getString("section");
        String Venue = b.getString("venue");
        Day=b.getString("Day");
        Date=b.getString("Date");
        //Getting id's of text views where we are going to show data from timetable
        SlotInAtd = (TextView) findViewById(R.id.slot);
        SubjectInAtd = (TextView) findViewById(R.id.subject);
        SectionInAtd = (TextView) findViewById(R.id.section);
        VenueInAtd = (TextView) findViewById(R.id.venue);
        //Setting Data in text Views
        SlotInAtd.setText(Slot);
        SubjectInAtd.setText(Subject);
        VenueInAtd.setText(Venue);
        SectionInAtd.setText(Section);


        // Getting Attendance Sheet from Database (Calling)
        AtdListRecyclerView = findViewById(R.id.RecyclerStdList);
        RetrofitClient client = RetrofitClient.getInstance();
        client.getMyApi().GetAttendanceList(Subject,Section).
                enqueue(new Callback<List<AttendanceSheetinfo>>() {
                    @Override
                    public void onResponse(Call<List<AttendanceSheetinfo>> call, Response<List<AttendanceSheetinfo>> response) {
                        if (response.isSuccessful()) {
                            Atdadapter = new StudentListAdp(response.body(), AttendanceSheet.this);
                            AtdListRecyclerView.setLayoutManager(new LinearLayoutManager(AttendanceSheet.this));
                            AtdListRecyclerView.setAdapter(Atdadapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<AttendanceSheetinfo>> call, Throwable t) {
                    }
                });

        // Getting Data to Submit Attendance

        //Submitting Attendance by clicking submit button
        int size = AtdListRecyclerView.getMeasuredHeight();
        Submitbtn=(Button)findViewById(R.id.Submit);
        Submitbtn.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v) {
                ArrayList<MarkingAttendance> markingList = new ArrayList<>();
                ArrayList<AttendanceSheetinfo> AttendanceList = new ArrayList<>();
                List<AttendanceSheetinfo> atd = Atdadapter.getAttendanceList();
                for (AttendanceSheetinfo obj:atd) {
                    MarkingAttendance ma = new MarkingAttendance();
                    ma.AridNo = obj.Regno;
                    ma.Status = obj.Status;
                    markingList.add(ma);
                }
                RetrofitClient client1 = RetrofitClient.getInstance();
                Api api = client1.getMyApi();
                api.SubmittingAttendance(markingList,
                        Date, 5,"CS-105","emp-101").enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getApplicationContext(), response.body(), Toast.LENGTH_LONG).show();
                        }else{
                            try{
                                Toast.makeText(getApplicationContext(), response.errorBody().string(), Toast.LENGTH_LONG).show();
                            }catch (Exception e){

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


            }
        });

        // Opening cam on clicking button
        ImageCapture = (Button) findViewById(R.id.send);
        ImageCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AttendanceSheet.this, CapturingImage.class);
                startActivity(intent);

            }
        });

    }
}