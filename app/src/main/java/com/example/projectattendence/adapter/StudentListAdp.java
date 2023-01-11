package com.example.projectattendence.adapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.example.projectattendence.R;
import com.example.projectattendence.Std_Atd_review;
import com.example.projectattendence.Student1;
import com.example.projectattendence.Teacher.AttendanceSheet;
import com.example.projectattendence.Teacher.Teacher1;
import com.example.projectattendence.api.Api;
import com.example.projectattendence.models.AttendanceList;
import com.example.projectattendence.models.AttendanceSheetinfo;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentListAdp extends RecyclerView.Adapter<StudentListAdp.MyViewHolder>{


    public class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView textViewUserName, textViewRegNo, textViewPercentage;
        ImageView Stdimage;
        Button Statusbtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Stdimage = itemView.findViewById(R.id.StdImage);
            textViewUserName = itemView.findViewById(R.id.textViewUserName);
            textViewRegNo = itemView.findViewById(R.id.textViewRegNo);
            textViewPercentage = itemView.findViewById(R.id.textViewPercentage);
            Statusbtn=itemView.findViewById(R.id.status);


        }
    }
    public List<AttendanceSheetinfo> getAttendanceList(){
        return AttendanceList;
    }
    List<AttendanceSheetinfo> AttendanceList;
    Context context;
    ArrayList<Bitmap> studentsPics = new ArrayList<>();

    public StudentListAdp(List<AttendanceSheetinfo> attendanceList, Context context) {
        AttendanceList = attendanceList;
        this.context = context;

//
//
//
//       AsyncTask<List<AttendanceSheetinfo> ,Void,ArrayList<Bitmap>> task = new AsyncTask<List<AttendanceSheetinfo> ,Void,ArrayList<Bitmap>>(){
//
//           @Override
//           protected ArrayList<Bitmap> doInBackground(List<AttendanceSheetinfo>... lists) {
//
//               ArrayList<Bitmap> bitmaps = new ArrayList<>();
//               for (AttendanceSheetinfo info : attendanceList) {
//                   try {
//                       String url = Api.IMAGE_URL + info.Path;
//                       Bitmap bitmap = Picasso.get().load(url).get();
//                       studentsPics.add(bitmap);
//                   }catch (Exception e){
//                       studentsPics.add(null);
//                   }
//
//               }
//               return bitmaps;
//           }
//
//           @Override
//           protected void onPostExecute(ArrayList<Bitmap> bitmaps) {
//               super.onPostExecute(bitmaps);
//               //studentsPics = bitmaps;
//               notifyDataSetChanged();
//           }
//       };
//       task.execute(attendanceList);
    }

    public StudentListAdp.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.students_list, parent, false);

        return new StudentListAdp.MyViewHolder(v);
}

    @Override
    public void onBindViewHolder(@NonNull StudentListAdp.MyViewHolder holder, int position) {
        AttendanceSheetinfo objStudentList = AttendanceList.get(position);

        holder.textViewUserName.setText(objStudentList.Regno);
        holder.textViewRegNo.setText(objStudentList.StudentName);
        holder.Statusbtn.setText(objStudentList.Status);
        holder.textViewPercentage.setText(objStudentList.Percentage);

           // if(studentsPics.get(position) != null)
           // holder.Stdimage.setImageBitmap(studentsPics.get(position));
        Picasso.get().load(Api.IMAGE_URL + objStudentList.Path).into(holder.Stdimage);
        if(objStudentList.Status.equalsIgnoreCase("P")){
            holder.Statusbtn.setBackgroundColor(Color.GREEN);
        }else{
            holder.Statusbtn.setBackgroundColor(Color.RED);
        }
        holder.Statusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               objStudentList.Status = objStudentList.Status.equalsIgnoreCase("P") ? "A" : "P";

               notifyDataSetChanged();
            }
        });

    }



    @Override
    public int getItemCount() {
        return getAttendanceList().size();
    }





}
