package com.example.projectattendence.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectattendence.R;
import com.example.projectattendence.Student1;
import com.example.projectattendence.models.StdEnrolledCoursesinfo;
import com.example.projectattendence.models.StudentAtdDetail;

import java.util.ArrayList;
import java.util.List;

public class StdDetailAdp extends RecyclerView.Adapter<StdDetailAdp.MyViewHolder>{

    public static class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView textViewSubject, textViewPercentage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);;
            textViewSubject = itemView.findViewById(R.id.stdtextViewSubject);
            textViewPercentage = itemView.findViewById(R.id.stdtextViewPercentage);
        }
    }
    List<StdEnrolledCoursesinfo> StdDetailList;
    Context context;

    public StdDetailAdp(List<StdEnrolledCoursesinfo> stdDetailList, Context context) {
        this.StdDetailList = stdDetailList;
        this.context = context;
    }

    public StdDetailAdp.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.std_atd_detail, parent, false);
        return new StdDetailAdp.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StdDetailAdp.MyViewHolder holder, int position) {
        StdEnrolledCoursesinfo objStudentDetail = StdDetailList.get(position);
        holder.textViewSubject.setText(objStudentDetail.C_Name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student1 s = (Student1) context;
                s.cellClicked(objStudentDetail);
            }
        });


    }

    @Override
    public int getItemCount() {
        return StdDetailList.size();
    }
}
