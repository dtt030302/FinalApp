package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.K204110582.finalapp.databinding.ActivityMainBinding;
import com.K204110582.finalapp.databinding.ActivitySearchBinding;
import com.K204110582.finalapp.databinding.ActivityUserBinding;

public class SearchActivity extends AppCompatActivity {
    ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_search);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void addEvents() {
        binding.edtSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                binding.txtSearchCancel.setVisibility(View.VISIBLE);
                binding.btnTittle.setVisibility(View.VISIBLE);
                binding.btnAuthor.setVisibility(View.VISIBLE);
                binding.btnCategory.setVisibility(View.VISIBLE);
                binding.btnTittle.setBackgroundColor(getResources().getColor(R.color.main_dark));
                binding.gridHot.setVisibility(View.GONE);
                return false;
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtSearchCancel.setVisibility(View.VISIBLE);
                binding.btnTittle.setVisibility(View.VISIBLE);
                binding.btnAuthor.setVisibility(View.VISIBLE);
                binding.btnCategory.setVisibility(View.VISIBLE);
                binding.btnTittle.setBackgroundColor(getResources().getColor(R.color.main_dark));
                binding.gridHot.setVisibility(View.GONE);
            }
        });
        binding.txtSearchCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);
                binding.btnAuthor.setBackgroundColor(getResources().getColor(R.color.main_light));
                binding.btnCategory.setBackgroundColor(getResources().getColor(R.color.main_light));
                binding.btnTittle.setBackgroundColor(getResources().getColor(R.color.main_light));
                binding.txtSearchCancel.setVisibility(View.GONE);
                binding.btnTittle.setVisibility(View.GONE);
                binding.btnAuthor.setVisibility(View.GONE);
                binding.btnCategory.setVisibility(View.GONE);
                binding.gridHot.setVisibility(View.VISIBLE);
            }

            private void hideKeyboard(View view) {
                InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
        binding.btnTittle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnTittle.setBackgroundColor(getResources().getColor(R.color.main_dark));
                binding.btnAuthor.setBackgroundColor(getResources().getColor(R.color.main_light));
                binding.btnCategory.setBackgroundColor(getResources().getColor(R.color.main_light));
            }
        });
        binding.btnAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnTittle.setBackgroundColor(getResources().getColor(R.color.main_light));
                binding.btnAuthor.setBackgroundColor(getResources().getColor(R.color.main_dark));
                binding.btnCategory.setBackgroundColor(getResources().getColor(R.color.main_light));
            }
        });
        binding.btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnTittle.setBackgroundColor(getResources().getColor(R.color.main_light));
                binding.btnAuthor.setBackgroundColor(getResources().getColor(R.color.main_light));
                binding.btnCategory.setBackgroundColor(getResources().getColor(R.color.main_dark));
            }
        });
    }
}