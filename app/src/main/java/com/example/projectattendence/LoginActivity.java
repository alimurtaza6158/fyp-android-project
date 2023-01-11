package com.example.projectattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectattendence.Teacher.Teacher1;
import com.example.projectattendence.api.RetrofitClient;
import com.example.projectattendence.models.LogInInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    public Button signin;
    public CheckBox showhidebtn;
    public EditText edtPassword, edtUsername;
    public String GetUserName;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edtUsername = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);
        signin = findViewById(R.id.signinbtn);
        showhidebtn = findViewById(R.id.ShowHIdePw);


        // Show Hide password Button

        showhidebtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });


        // Action performing by clicking signin Button

        signin.setOnClickListener(v -> {

            // Getting username to second activity

            Bundle b = new Bundle();
            RetrofitClient client = RetrofitClient.getInstance();
            GetUserName = edtUsername.getText().toString();

            // Calling

            client.getMyApi().CheckLogin(
                    edtUsername.getText().toString(),
                    edtPassword.getText().toString()
            ).enqueue(new Callback<LogInInfo>() {
                public void onResponse(Call<LogInInfo> call, Response<LogInInfo> response) {
                    if (response.code() == 200) {
                        LogInInfo obj = response.body();
                        if (obj.Role.equals("Student")) {
                            b.putString("userName", GetUserName);
                            Intent intent = new Intent(LoginActivity.this, Student1.class);
                            intent.putExtras(b);
                            startActivity(intent);
                        } else if (obj.Role.equals("Admin")) {
                            Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                            startActivity(intent);
                        } else if (obj.Role.equals("Teacher")) {
                            b.putString("userName", GetUserName);
                            Intent intent = new Intent(LoginActivity.this, Teacher1.class);
                            intent.putExtras(b);
                            startActivity(intent);
                        } else if (obj.Role.equals("Parent")) {
                            b.putString("userName", GetUserName);
                            Intent intent = new Intent(LoginActivity.this, Parent1.class);
                            intent.putExtras(b);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "unable to login", Toast.LENGTH_LONG).show();
                    }
                }


                @Override
                public void onFailure(Call<LogInInfo> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        });


    }
}