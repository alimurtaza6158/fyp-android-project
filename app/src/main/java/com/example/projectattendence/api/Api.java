package com.example.projectattendence.api;

import com.example.projectattendence.models.AttendanceSheetinfo;
import com.example.projectattendence.models.GettingAtdInfo;
import com.example.projectattendence.models.LogInInfo;
import com.example.projectattendence.models.MarkingAttendance;
import com.example.projectattendence.models.ParentsInfo;
import com.example.projectattendence.models.StdEnrolledCoursesinfo;
import com.example.projectattendence.models.TImeTableInfo;


import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "http://192.168.43.173/FYPAPI/api/FYP/";
    static String IMAGE_URL = "http://192.168.43.173/FYPAPI/Images/";

    @GET("CheckLogin")
    public Call<LogInInfo> CheckLogin(
            @Query("userName") String userName,
            @Query("password") String userPassword
    );
    @GET("GetTimeTable")
    public Call<List<TImeTableInfo>> GetTimeTable(
            @Query("UserName") String UserName,
            @Query("Day") String Day

    );
    @GET("GetAttendanceList")
    public Call<List<AttendanceSheetinfo>> GetAttendanceList(
            @Query("cname") String Course_Name,
            @Query("section") String Section
    );
//    @GET("GetDataToSubmitAtd")
//    public Call<List<AttendanceSheetinfo>> GetAttendanceList(
//            @Query("cname") String Course_Name,
//            @Query("section") String Section,
//            @Query("day") String day,
//            @Query("slot") String slot
//    );


    @POST("SubmittingAttendance")
    public Call<String> SubmittingAttendance(@Body
            List<MarkingAttendance> attendanceList,
                                             @Query("date") String date,
                                             @Query("timetable") int timetable,
                                             @Query("coursecode") String coursecode,
                                             @Query("tid") String tid

                                             );
    @GET("GetStudentEnrolledCourse")
    public Call<List<StdEnrolledCoursesinfo>> GetStudentEnrolledCourse(
            @Query("UserName") String UserName
    );

   @GET("GetStudentAttendance")
   public Call<List<GettingAtdInfo>> GetStudentAttendance(
     @Query("UserName") String UserName,
     @Query("Course") String Course
   );


    @GET("GetParentsChild")
    public Call<List<ParentsInfo>> GetParentChild(
            @Query("P_username") String UserName
    );




}
