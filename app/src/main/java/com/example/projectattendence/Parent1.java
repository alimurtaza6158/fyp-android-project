package com.example.projectattendence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.projectattendence.adapter.ParentAdp;
import com.example.projectattendence.api.RetrofitClient;
import com.example.projectattendence.models.Childeren;
import com.example.projectattendence.models.EnrolledCourseofChild;
import com.example.projectattendence.models.ParentsInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Parent1 extends AppCompatActivity {
    RecyclerView ChildnameRecyclerView;
    ParentAdp childadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent1);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String UserName = b.getString("userName");


        ChildnameRecyclerView = findViewById(R.id.ParentRecycler);
        ArrayList<Childeren> childerenArrayList = new ArrayList<>();

        RetrofitClient Client = RetrofitClient.getInstance();

        Client.getMyApi().GetParentChild(UserName).
                enqueue(new Callback<List<ParentsInfo>>() {
                    @Override
                    public void onResponse(Call<List<ParentsInfo>> call, Response<List<ParentsInfo>> response)
                    {
                       if(response.isSuccessful()) {
                           childadapter = new ParentAdp( response.body(),Parent1.this);
                           ChildnameRecyclerView.setLayoutManager(new LinearLayoutManager(Parent1.this));
                           ChildnameRecyclerView.setAdapter(childadapter);
                       }
                    }

                    @Override
                    public void onFailure(Call<List<ParentsInfo>> call, Throwable t) {

                    }
                });


        //
//        childerenArrayList.add(new Childeren("Ali Murtaza", "2019-Arid-0074"));
//        childerenArrayList.add(new Childeren("Luqman", "2020-Arid-1234"));
//
//        childadapter = new ParentAdp(childerenArrayList, this);
//        ChildnameRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        ChildnameRecyclerView.setAdapter(childadapter);

    }
        public void cellClicked(EnrolledCourseofChild objCourse){
            Intent intent = new Intent(this, Parent2.class);
            Bundle b = new Bundle();
            b.putString("course", objCourse.getCourse());
            intent.putExtras(b);
            startActivity(intent);
        }



}