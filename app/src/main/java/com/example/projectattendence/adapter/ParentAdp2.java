package com.example.projectattendence.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectattendence.R;
import com.example.projectattendence.models.Childeren;
import com.example.projectattendence.models.EnrolledCourseofChild;

import java.util.ArrayList;

public class ParentAdp2 extends RecyclerView.Adapter<ParentAdp2.MyViewHolder>{
    public static class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView Course,AtdPer;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);;
            Course= itemView.findViewById(R.id.ParentSideCourse);
            AtdPer = itemView.findViewById(R.id.ParentSideAtdPer);
        }
    }
    ArrayList<EnrolledCourseofChild>EnrolledCourseArrayList;
    Context context;

    public ParentAdp2(ArrayList<EnrolledCourseofChild> enrolledCourseArrayList, Context context) {
        EnrolledCourseArrayList = enrolledCourseArrayList;
        this.context = context;
    }

    public ParentAdp2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.enrolled_course_of_child, parent, false);
        return new ParentAdp2.MyViewHolder(v);
    }

    public void onBindViewHolder(@NonNull ParentAdp2.MyViewHolder holder, int position) {
        EnrolledCourseofChild objcourse = EnrolledCourseArrayList.get(position);
        holder.Course.setText(objcourse.getCourse());
        holder.AtdPer.setText(objcourse.getAtdPercentage());

    }

    @Override
    public int getItemCount() {
        return EnrolledCourseArrayList.size();
    }
}
