package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.K204110582.finalapp.databinding.ActivityInformationBinding;
import com.K204110582.finalapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.txtDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = findViewById(R.id.chb_pass);
                EditText editText = findViewById(R.id.txt_tdn_Email);
                EditText passedText = findViewById(R.id.txt_Password);
                String tdn_email = editText.getText().toString();
                String passText = passedText.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (TextUtils.isEmpty(tdn_email) || TextUtils.isEmpty(passText)) {
                    Toast.makeText(LoginActivity.this, "Vui lòng điền đầy đủ thông tin đăng nhập",Toast.LENGTH_LONG).show();
                }
                else {
                    if (tdn_email.matches(emailPattern)) {
                        if (checkBox.isChecked())
                        {

                            SharedPreferences sharedPreferences = getSharedPreferences(WaitActivity.PREFS_NAME,0);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("hasLoggedIn",true);
                            editor.apply();
                            Intent intent = new Intent(LoginActivity.this,UserActivity.class);
                            intent.putExtra("email",tdn_email);
                            startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent(LoginActivity.this,UserActivity.class);
                            intent.putExtra("email",tdn_email);
                            startActivity(intent);
                        }
                    }
                    else {
                        if (checkBox.isChecked())
                        {

                            SharedPreferences sharedPreferences = getSharedPreferences(WaitActivity.PREFS_NAME,0);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("hasLoggedIn",true);
                            editor.apply();
                            Intent intent = new Intent(LoginActivity.this,UserActivity.class);
                            intent.putExtra("tdn",tdn_email);
                            startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent(LoginActivity.this,UserActivity.class);
                            intent.putExtra("tdn",tdn_email);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
        binding.txtQuenmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
        binding.btnLoginfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                String value1 = "Emailfacebook@gmail.com";
                String value2 = "Tên FB";
                intent.putExtra("email",value1);
                intent.putExtra("tdn",value2);
                startActivity(intent);
            }
        });
        binding.btnLogingg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                String value1 = "Google@gmail.com";
                String value2 = "Tên GG";
                intent.putExtra("email",value1);
                intent.putExtra("tdn",value2);
                startActivity(intent);
            }
        });

    }
}