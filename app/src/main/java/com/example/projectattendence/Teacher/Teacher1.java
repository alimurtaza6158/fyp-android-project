package com.example.projectattendence.Teacher;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import com.example.projectattendence.R;
import com.example.projectattendence.adapter.RecyclerAdapter;
import com.example.projectattendence.api.RetrofitClient;
import com.example.projectattendence.models.TImeTableInfo;
import com.example.projectattendence.models.TimeTable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Teacher1 extends AppCompatActivity {
//    private ArrayList<TimeTable>list;
     Spinner Days;
    RecyclerView timetableRecyclerView;
    RecyclerAdapter adapter;
    DatePickerDialog.OnDateSetListener setListener;
   public Button calendarbtn;
   String CurrentDay="";
   String CurrentDate="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher1);

        // Getting username from login activity
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String UserName = b.getString("userName");

        // Datepicker

        Calendar calendar = Calendar.getInstance();
        final int dayfromdatepicker = calendar.get(Calendar.DAY_OF_MONTH);
        final int monthfromdatepicker = calendar.get(Calendar.MONTH);
        final int yearfromdatepicker = calendar.get(Calendar.YEAR);



        // System's Date
        TextView Date = findViewById(R.id.Date);
        TextView Day = findViewById(R.id.Day);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat currentdate = new SimpleDateFormat("dd/MM/yyyy");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat currentday = new SimpleDateFormat("EEEE");
        CurrentDate = currentdate.format(new Date());
        CurrentDay = currentday.format(new Date());
        Date.setText(CurrentDate);
        Day.setText(CurrentDay);

               // Changing Date from calendar
        calendarbtn=(Button) findViewById(R.id.Calendar);
        calendarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datepickerdialog=new DatePickerDialog(
                        Teacher1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                      month=month+1;
                      String DatefromDatepicker = day+"/"+month+"/"+year;
                        Date.setText(DatefromDatepicker);
                    }
                },yearfromdatepicker,monthfromdatepicker,dayfromdatepicker);
                datepickerdialog.show();


            }
        });

              //spinner code

        Days=findViewById(R.id.Dayspinner);
        ArrayList<String> DaysArrayList = new ArrayList<>();
        DaysArrayList.add("Monday");
        DaysArrayList.add("Tuesday");
        DaysArrayList.add("Wednesday");
        DaysArrayList.add("Thursday");
        DaysArrayList.add("Friday");

        ArrayAdapter<String> DaysAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, DaysArrayList);
        DaysAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Days.setAdapter(DaysAdapter);
        Days.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
               // String tutorialsName = parent.getItemAtPosition(position).toString();
                switch(position)
                {
                    case 1:
                        Day.setText("Monday");
                        CurrentDay="Monday";
                        break;
                    case 2:
                        Day.setText("Tuesday");
                        CurrentDay="Tuesday";
                        break;
                    case 3:
                        Day.setText("Wednesday");
                        CurrentDay="Wednesday";
                        break;
                    case 4:
                        Day.setText("Thursday");
                        CurrentDay="Thursday";
                        break;
                    case 5:
                        Day.setText("Friday");
                        CurrentDay="Friday";
                        break;

                }
                RetrofitClient client = RetrofitClient.getInstance();
                client.getMyApi().GetTimeTable(UserName,CurrentDay).
                        enqueue(new Callback<List<TImeTableInfo>>()
                        {
                            @Override public void onResponse(Call<List<TImeTableInfo>> call, Response<List<TImeTableInfo>> response)
                            {
                                if(response.isSuccessful()) {
                                    adapter = new RecyclerAdapter(Teacher1.this, response.body());
                                    timetableRecyclerView.setLayoutManager(new LinearLayoutManager(Teacher1.this));
                                    timetableRecyclerView.setAdapter(adapter);
                                }
                            }
                            @Override public void onFailure(Call<List<TImeTableInfo>> call, Throwable t) {

                            }
                        });

                //Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,          Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });



        // Time Table from API
        timetableRecyclerView = findViewById(R.id.recyclerview);
        ArrayList<TimeTable> timeTableArrayList = new ArrayList<>();

        RetrofitClient client = RetrofitClient.getInstance();
        client.getMyApi().GetTimeTable(UserName,CurrentDay).
                enqueue(new Callback<List<TImeTableInfo>>()
                {
                    @Override public void onResponse(Call<List<TImeTableInfo>> call, Response<List<TImeTableInfo>> response)
                    {
                        if(response.isSuccessful()) {
                            adapter = new RecyclerAdapter(Teacher1.this, response.body());
                            timetableRecyclerView.setLayoutManager(new LinearLayoutManager(Teacher1.this));
                            timetableRecyclerView.setAdapter(adapter);
                                                         }
                    }
                    @Override public void onFailure(Call<List<TImeTableInfo>> call, Throwable t) {

                    }
                });


    }

    // By clicking on a cell moving to next activity and moving data from on activity to another

    public void cellClicked(TImeTableInfo objTimeTable) {
        Intent intent = new Intent(this, AttendanceSheet.class);
        Bundle b = new Bundle();

        b.putString("slot", objTimeTable.Slot);
        b.putString("section", objTimeTable.Title);
        b.putString("subject", objTimeTable.C_Name);
        b.putString("venue", objTimeTable.Venue);
        b.putString("Day",CurrentDay);
        b.putString("Date",CurrentDate);


        intent.putExtras(b);
        startActivity(intent);
    }
}