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
import com.K204110582.finalapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_register);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = findViewById(R.id.chb_dkdv);
                EditText editText1 = findViewById(R.id.txt_Email);
                EditText editText2 = findViewById(R.id.txt_tdn);
                EditText editText3 = findViewById(R.id.txt_Password);
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText3.getText().toString();
                if (TextUtils.isEmpty(text2) || TextUtils.isEmpty(text1) || TextUtils.isEmpty(text3)) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng điền đầy đủ thông tin đăng ký",Toast.LENGTH_LONG).show();
                }
                else {
                    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                    if (text1.matches(emailPattern))
                    {
                        if (checkBox.isChecked()) {
                            SharedPreferences sharedPreferences = getSharedPreferences(WaitActivity.PREFS_NAME,0);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("hasLoggedIn",true);
                            editor.apply();
                            EditText e1 = findViewById(R.id.txt_Email);
                            String value1 = e1.getText().toString();
                            EditText e2 = findViewById(R.id.txt_tdn);
                            String value2 = e2.getText().toString();
                            Intent intent = new Intent(RegisterActivity.this,InformationActivity.class);
                            intent.putExtra("email",value1);
                            intent.putExtra("tdn",value2);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Vui lòng tick chọn đồng ý với điều khoản dịch vụ" , Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this,"Địa chỉ email không chính xác", Toast.LENGTH_SHORT).show();
                        editText1.requestFocus();
                    }
                }
            }
        });
        binding.txtDkdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,dkdvActivity.class);
                startActivity(intent);
            }
        });
        binding.btnLoginfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, InformationActivity.class);
                String value1 = "Emailfacebook@gmail.com";
                String value2 = "Tên tài khoản FB";
                intent.putExtra("email",value1);
                startActivity(intent);
            }
        });
        binding.btnLogingg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, InformationActivity.class);
                String value1 = "Google@gmail.com";
                String value2 = "Tên tài khoản Google";
                intent.putExtra("email",value1);
                startActivity(intent);
            }
        });
    }
}