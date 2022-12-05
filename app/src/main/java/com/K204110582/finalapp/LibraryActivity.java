package com.K204110582.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RatingBar;

import com.K204110582.adapters.Books;
import com.K204110582.adapters.ReadingAdapter;
import com.K204110582.finalapp.databinding.ActivityLibraryBinding;
import com.K204110582.finalapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {
    ActivityLibraryBinding binding;
    ReadingAdapter readingAdapter1;
    ReadingAdapter readingAdapter2;

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
        loadReadingData();
        addEvents();
    }

    private void loadReadingData() {
        readingAdapter1 = new ReadingAdapter(LibraryActivity.this,R.layout.grid_library_layout,BookActivity.bookslistreading);
        binding.gridReading.setAdapter(readingAdapter1);
        readingAdapter2 = new ReadingAdapter(LibraryActivity.this,R.layout.grid_library_layout,BookActivity.bookslistwishlist);
        binding.gridWishlist.setAdapter(readingAdapter2);
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
                binding.gridWishlist.setVisibility(View.VISIBLE);
                binding.gridReading.setVisibility(View.GONE);
            }
        });
        binding.gridReading.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LibraryActivity.this,BookActivity.class);
                intent.putExtra("bookname",BookActivity.bookslistreading.get(position).getBookName());
                intent.putExtra("bookimage",BookActivity.bookslistreading.get(position).getBookThumb());
                intent.putExtra("bookId",BookActivity.bookslistreading.get(position).getBookId());
                intent.putExtra("authorname",BookActivity.bookslistreading.get(position).getAuthor_name());
                intent.putExtra("price",BookActivity.bookslistreading.get(position).getPrice());
                intent.putExtra("groupchatid",BookActivity.bookslistreading.get(position).getGroup_chat_id());
                intent.putExtra("rating",BookActivity.bookslistreading.get(position).getRating());
                intent.putExtra("source",0);
                startActivity(intent);
            }
        });
        binding.gridWishlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LibraryActivity.this,BookActivity.class);
                intent.putExtra("bookname",BookActivity.bookslistwishlist.get(position).getBookName());
                intent.putExtra("bookimage",BookActivity.bookslistwishlist.get(position).getBookThumb());
                intent.putExtra("bookId",BookActivity.bookslistwishlist.get(position).getBookId());
                intent.putExtra("authorname",BookActivity.bookslistwishlist.get(position).getAuthor_name());
                intent.putExtra("price",BookActivity.bookslistwishlist.get(position).getPrice());
                intent.putExtra("groupchatid",BookActivity.bookslistwishlist.get(position).getGroup_chat_id());
                intent.putExtra("rating",BookActivity.bookslistwishlist.get(position).getRating());
                intent.putExtra("source",0);
                startActivity(intent);
            }
        });
    }
}