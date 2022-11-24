package com.K204110582.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.K204110582.adapters.Books;
import com.K204110582.adapters.ReadingAdapter;
import com.K204110582.finalapp.databinding.ActivityLibraryBinding;
import com.K204110582.finalapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {
    ActivityLibraryBinding binding;
    ReadingAdapter readingAdapter;
    ArrayList<Books> bookslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_library);
        binding = ActivityLibraryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.library);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.library:
                        return true;
                    case R.id.chat:
                        startActivity(new Intent(getApplicationContext(),ChatActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),UserActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        addEvents();
        loadReadingData();
    }

    private void loadReadingData() {
        bookslist = new ArrayList<>();
        bookslist.add(new Books(29,"123",123,123,R.drawable.fulllogo,4,123));
        readingAdapter = new ReadingAdapter(LibraryActivity.this,R.layout.grid_layout,bookslist);
        binding.gridReading.setAdapter(readingAdapter);
    }

    private void addEvents() {
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        binding.btnReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnReading.setBackgroundColor(getResources().getColor(R.color.main_darkest));
                binding.btnWishlist.setBackgroundColor(getResources().getColor(R.color.main_dark));
                binding.gridReading.setVisibility(View.VISIBLE);
                binding.gridWishlist.setVisibility(View.GONE);
            }
        });
        binding.btnWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnReading.setBackgroundColor(getResources().getColor(R.color.main_dark));
                binding.btnWishlist.setBackgroundColor(getResources().getColor(R.color.main_darkest));
                binding.gridReading.setVisibility(View.GONE);
                binding.gridWishlist.setVisibility(View.VISIBLE);
            }
        });
    }
}