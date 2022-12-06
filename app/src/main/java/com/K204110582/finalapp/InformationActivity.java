package com.K204110582.finalapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.K204110582.finalapp.databinding.ActivityInformationBinding;


public class InformationActivity extends AppCompatActivity {
    ActivityInformationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_information);
        binding = ActivityInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showData();
        addEvents();
    }

    private void addEvents() {
        binding.btnToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.edt_mail);
                EditText editText1 = findViewById(R.id.edt_tdn);
                EditText editText2 = findViewById(R.id.edt_name);
                String text = editText.getText().toString();
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (TextUtils.isEmpty(text) || TextUtils.isEmpty(text1)) {
                    Toast.makeText(InformationActivity.this,"Vui lòng điền vào các thông tin bắt buộc", Toast.LENGTH_LONG).show();
                }
                else {
                    if (text.matches(emailPattern))
                    {
                        Intent intent = new Intent(InformationActivity.this,UserActivity.class);
                        intent.putExtra("email",text);
                        intent.putExtra("tdn",text1);
                        intent.putExtra("hovaten",text2);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(InformationActivity.this,"Địa chỉ email không chính xác", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void showData() {
        Intent intent = getIntent();
        String text = intent.getStringExtra("email");
        String text1 = intent.getStringExtra("tdn");
        if (TextUtils.isEmpty(text)) {
        }
        else {
            binding.edtMail.setText(text);
            binding.edtMail.setFocusable(false);
            binding.edtMail.setFocusableInTouchMode(false);
            binding.edtMail.setClickable(false);
        }
        if (TextUtils.isEmpty(text1)) {
        }
        else {
            binding.edtTdn.setText(text1);
            binding.edtTdn.setFocusable(false);
            binding.edtTdn.setFocusableInTouchMode(false);
            binding.edtTdn.setClickable(false);
        }
    }
}