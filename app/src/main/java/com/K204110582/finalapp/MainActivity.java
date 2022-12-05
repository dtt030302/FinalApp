package com.K204110582.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.K204110582.adapters.Books;
import com.K204110582.adapters.Category;
import com.K204110582.adapters.CategoryAdapter;
import com.K204110582.adapters.ReadingAdapter;
import com.K204110582.finalapp.databinding.ActivityLibraryBinding;
import com.K204110582.finalapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.library:
                        startActivity(new Intent(getApplicationContext(),LibraryActivity.class));
                        overridePendingTransition(0,0);
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
        loadData();
        addEvents();
    }

    private void loadData() {
        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(this,getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }

    private List<Category> getListCategory() {
        List<Category> listCategory = new ArrayList<>();

        List<Books> listBookfree = new ArrayList<>();
        listBookfree.add(new Books(1,"Sensation","Nguyễn Thị Nghi Xuân",0,R.drawable.free1,4,1));
        listBookfree.add(new Books(2,"The past is rising","Đỗ Thị Thanh Trúc",0,R.drawable.free2,3,2));
        listBookfree.add(new Books(3,"Satellite","Nguyễn Thị Nghi Xuân",0,R.drawable.free3,2,3));
        listBookfree.add(new Books(4,"Last to rise","Đỗ Thị Thanh Trúc",0,R.drawable.free4,1,4));
        listBookfree.add(new Books(5,"The one and only","Nguyễn Thị Nghi Xuân",0,R.drawable.free5,4,5));

        List<Books> listBookcost = new ArrayList<>();
        listBookcost.add(new Books(6,"The final six","Đỗ Thị Thanh Trúc",30000,R.drawable.cost1,5,6));
        listBookcost.add(new Books(7,"Cold lake","Nguyễn Thị Nghi Xuân",50000,R.drawable.cost2,2,7));
        listBookcost.add(new Books(8,"His life","Đỗ Thị Thanh Trúc",40000,R.drawable.cost3,3,8));
        listBookcost.add(new Books(9,"Black moon","Nguyễn Thị Nghi Xuân",50000,R.drawable.cost4,2,9));
        listBookcost.add(new Books(10,"This is not the end","Nguyễn Thị Nghi Xuân",70000,R.drawable.cost5,3,10));

        List<Books> listBookforyou = new ArrayList<>();
        listBookforyou.add(new Books(1,"Sensation","Nguyễn Thị Nghi Xuân",0,R.drawable.free1,4,1));
        listBookforyou.add(new Books(10,"This is not the end","Nguyễn Thị Nghi Xuân",70000,R.drawable.cost5,3,10));
        listBookforyou.add(new Books(2,"The past is rising","Đỗ Thị Thanh Trúc",0,R.drawable.free2,3,2));
        listBookforyou.add(new Books(5,"The one and only","Nguyễn Thị Nghi Xuân",0,R.drawable.free5,4,5));
        listBookforyou.add(new Books(6,"The final six","Đỗ Thị Thanh Trúc",30000,R.drawable.cost1,5,6));
        listBookforyou.add(new Books(7,"Cold lake","Nguyễn Thị Nghi Xuân",50000,R.drawable.cost2,2,7));
        listBookforyou.add(new Books(3,"Satellite","Nguyễn Thị Nghi Xuân",0,R.drawable.free3,2,3));
        listBookforyou.add(new Books(4,"Last to rise","Đỗ Thị Thanh Trúc",0,R.drawable.free4,1,4));
        listBookforyou.add(new Books(8,"His life","Đỗ Thị Thanh Trúc",40000,R.drawable.cost3,3,8));
        listBookforyou.add(new Books(9,"Black moon","Nguyễn Thị Nghi Xuân",50000,R.drawable.cost4,2,9));

        listCategory.add(new Category("Truyện dành cho bạn",listBookforyou));
        listCategory.add(new Category("Truyện tính phí",listBookcost));
        listCategory.add(new Category("Truyện miễn phí",listBookfree));
        return listCategory;
    }


    private void addEvents() {
        binding.rcvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BookActivity.class);
                startActivity(intent);
            }
        });
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        binding.btnHomeToLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LibraryActivity.class);
                startActivity(intent);
            }
        });
    }
}