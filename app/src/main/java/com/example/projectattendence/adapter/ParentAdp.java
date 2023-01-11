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
import com.example.projectattendence.models.ParentsInfo;

import java.util.ArrayList;
import java.util.List;

public class ParentAdp extends RecyclerView.Adapter<ParentAdp.MyViewHolder>{

    List<ParentsInfo> childerenList;
    Context context;

    public ParentAdp(List<ParentsInfo> childerenList, Context context) {
        this.childerenList = childerenList;
        this.context = context;
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView childname,Regno;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);;
            childname = itemView.findViewById(R.id.childname);
            Regno = itemView.findViewById(R.id.ParentsideRegno);
        }
    }


    public ParentAdp.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.childofparent, parent, false);
        return new ParentAdp.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdp.MyViewHolder holder, int position) {
        ParentsInfo objchild = childerenList.get(position);
        holder.childname.setText(objchild.StudentName);
        holder.Regno.setText(objchild.Regno);

    }

    @Override
    public int getItemCount() {
        return childerenList.size();
    }
}
