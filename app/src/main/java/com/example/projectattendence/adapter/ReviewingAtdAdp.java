package com.example.projectattendence.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectattendence.R;
import com.example.projectattendence.models.AtdReview;
import com.example.projectattendence.models.GettingAtdInfo;

import java.util.ArrayList;
import java.util.List;

public class ReviewingAtdAdp extends RecyclerView.Adapter<ReviewingAtdAdp.MyViewHolder> {

    public static class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView StudentSideDay,StudentSideDate,StudentSideSlot,StudentAttendanceStatus;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);;
            StudentSideDay = itemView.findViewById(R.id.StdSideDay);
            StudentSideDate = itemView.findViewById(R.id.StdSideDate);
            StudentSideSlot = itemView.findViewById(R.id.StdSideSlot);
            StudentAttendanceStatus = itemView.findViewById(R.id.StdAtdStatus);
        }
    }
    List<GettingAtdInfo>AttendanceReviewArrayList;
    Context context;

    public ReviewingAtdAdp(List<GettingAtdInfo> attendanceReviewArrayList, Context context) {
        AttendanceReviewArrayList = attendanceReviewArrayList;
        this.context = context;
    }

    public ReviewingAtdAdp.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.std_atd_status, parent, false);

        return new ReviewingAtdAdp.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewingAtdAdp.MyViewHolder holder, int position) {
        GettingAtdInfo objAtdStatus = AttendanceReviewArrayList.get(position);
        holder.StudentSideDate.setText(objAtdStatus .Date);
        holder.StudentSideDay.setText(objAtdStatus .day);
        holder.StudentSideSlot.setText(objAtdStatus . slot);
        holder.StudentAttendanceStatus.setText(objAtdStatus .Status);


    }

    @Override
    public int getItemCount() {
        return AttendanceReviewArrayList.size();
    }
}
