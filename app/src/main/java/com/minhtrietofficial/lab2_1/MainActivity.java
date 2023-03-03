package com.minhtrietofficial.lab2_1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsername, txtPassword;
    private CheckBox chbRemember;
    private Button btnLogin;
    private Button btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        chbRemember = findViewById(R.id.chbRemember);
        btnLogin = findViewById(R.id.btnLogin);
        btnReset = findViewById(R.id.btnReset);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvent();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickResetEvent();
            }
        });
        chbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                String message = checked ? "Mật khẩu đã được lưu" : "";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void handleClickResetEvent(){
        String username = txtUsername.getText().toString().trim();
        String user = "admin";

        if(username.isEmpty()){
            Toast.makeText(this, "Vui lòng nhập username",
                    Toast.LENGTH_SHORT).show();
            txtUsername.requestFocus();
        }

        else if (username.equals(user)){
                Toast.makeText(this, "Reset mật khẩu thành công",
                        Toast.LENGTH_SHORT).show();
        }

    }
    private void handleClickEvent(){
        String username = txtUsername.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        String user = "admin";
        String pass = "admin1234";

        if(username.isEmpty()){
            Toast.makeText(this, "Vui lòng nhập username",
                    Toast.LENGTH_SHORT).show();
            txtUsername.requestFocus();
        }
        else if(password.isEmpty()){
            Toast.makeText(this, "Vui lòng nhập password",
                    Toast.LENGTH_SHORT).show();
            txtPassword.requestFocus();
        }
        else if (username.equals(user)){
            if (password.equals(pass)) {
                Toast.makeText(this, "Đăng nhập thành công",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Đăng nhập thất bại",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, username + password,
                    Toast.LENGTH_SHORT).show();
        }


    }
}