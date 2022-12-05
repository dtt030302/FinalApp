package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.K204110582.finalapp.databinding.ActivityPersonalBinding;

public class PersonalActivity extends AppCompatActivity {
    ActivityPersonalBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_personal);
        binding = ActivityPersonalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {

    }
}