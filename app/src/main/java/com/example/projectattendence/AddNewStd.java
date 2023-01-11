package com.example.projectattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class AddNewStd extends AppCompatActivity {
    Spinner Deg;
    Spinner Dis;
    Spinner Sem;
    Spinner Sec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_std);
        Deg=findViewById(R.id.degree);
        Dis=findViewById(R.id.discipline);
        Sem=findViewById(R.id.semester);
        Sec=findViewById(R.id.section);
        ArrayList<String> DegreeList = new ArrayList<>();

        DegreeList.add("Bachelor's");
        DegreeList.add("master's");


        ArrayAdapter<String> DegreeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, DegreeList);
        DegreeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Deg.setAdapter(DegreeAdapter);


        Deg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // String tutorialsName = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,          Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });








        ArrayList<String> DisciplineList = new ArrayList<>();
        DisciplineList.add("BsCS");
        DisciplineList.add("BsIT");
        DisciplineList.add("BsAI");
        DisciplineList.add("Mcs");
        DisciplineList.add("Bcs");

        ArrayAdapter<String> DisciplineAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, DisciplineList);
        DisciplineAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Dis.setAdapter(DisciplineAdapter);
        Dis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String tutorialsName = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,          Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        ArrayList<String> SemesterList = new ArrayList<>();
        SemesterList.add("1");
        SemesterList.add("2");
        SemesterList.add("3");
        SemesterList.add("4");
        SemesterList.add("5");
        SemesterList.add("6");
        SemesterList.add("7");
        SemesterList.add("8");
        ArrayAdapter<String> SemesterAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, SemesterList);
        SemesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Sem.setAdapter(SemesterAdapter);
        Sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String tutorialsName = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,          Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        ArrayList<String> SectionList = new ArrayList<>();
        SectionList.add("A");
        SectionList.add("B");
        SectionList.add("C");
        SectionList.add("D");
        ArrayAdapter<String> SectionAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, SectionList);
        SectionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Sec.setAdapter(SectionAdapter);
        Sec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String tutorialsName = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,          Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });








    }
}