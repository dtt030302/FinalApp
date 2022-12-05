package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.K204110582.finalapp.databinding.ActivityChangePassNotiBinding;
import com.K204110582.finalapp.databinding.ActivityChangePasswordBinding;

public class ChangePassNotiActivity extends AppCompatActivity {
    ActivityChangePassNotiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_change_pass_noti);
        binding = ActivityChangePassNotiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.txtOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}