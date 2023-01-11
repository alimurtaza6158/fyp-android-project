package com.example.projectattendence.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectattendence.R;
import com.example.projectattendence.Teacher.Teacher1;
import com.example.projectattendence.models.TImeTableInfo;
import com.example.projectattendence.models.TimeTable;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    List<TImeTableInfo> timeTableList;
    Context context;
    public  RecyclerAdapter(Context context, List<TImeTableInfo> timeTableList ){
            this.context = context;
            this.timeTableList = timeTableList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.time_table_cell, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TImeTableInfo objTimeTable = timeTableList.get(position);
        holder.textViewSlot.setText(objTimeTable.Slot);
        holder.textViewSection.setText(objTimeTable.Title);
        holder.textViewVenue.setText(objTimeTable.Venue);
        holder.textViewSubject.setText(objTimeTable.C_Name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Teacher1 teacher1 = (Teacher1)context;
                teacher1.cellClicked(objTimeTable);
            }
        });
    }

    @Override
    public int getItemCount() {
        return timeTableList.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView textViewSlot, textViewVenue, textViewSubject, textViewSection;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSlot = itemView.findViewById(R.id.textViewSlot);
            textViewSubject = itemView.findViewById(R.id.textViewSubject);
            textViewVenue = itemView.findViewById(R.id.textViewVenue);
            textViewSection = itemView.findViewById(R.id.textViewSection);
        }
    }
}
