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
        listBookfree.add(new Books(1,"Sensation","Nguy????n Thi?? Nghi Xu??n",0,R.drawable.free1,4,0));
        listBookfree.add(new Books(2,"The past is rising","?????? Thi?? Thanh Tru??c",0,R.drawable.free2,3,0));
        listBookfree.add(new Books(3,"Satellite","Nguy????n Thi?? Nghi Xu??n",0,R.drawable.free3,2,0));
        listBookfree.add(new Books(4,"Last to rise","?????? Thi?? Thanh Tru??c",0,R.drawable.free4,1,0));
        listBookfree.add(new Books(5,"The one and only","Nguy????n Thi?? Nghi Xu??n",0,R.drawable.free5,4,0));

        List<Books> listBookcost = new ArrayList<>();
        listBookcost.add(new Books(6,"The final six","?????? Thi?? Thanh Tru??c",30000,R.drawable.cost1,5,0));
        listBookcost.add(new Books(7,"Cold lake","Nguy????n Thi?? Nghi Xu??n",50000,R.drawable.cost2,2,0));
        listBookcost.add(new Books(8,"His life","?????? Thi?? Thanh Tru??c",40000,R.drawable.cost3,3,0));
        listBookcost.add(new Books(9,"Black moon","Nguy????n Thi?? Nghi Xu??n",50000,R.drawable.cost4,2,0));
        listBookcost.add(new Books(10,"This is not the end","Nguy????n Thi?? Nghi Xu??n",70000,R.drawable.cost5,3,0));

        List<Books> listBookforyou = new ArrayList<>();
        listBookforyou.add(new Books(1,"Sensation","Nguy????n Thi?? Nghi Xu??n",0,R.drawable.free1,4,0));
        listBookforyou.add(new Books(10,"This is not the end","Nguy????n Thi?? Nghi Xu??n",70000,R.drawable.cost5,3,0));
        listBookforyou.add(new Books(2,"The past is rising","?????? Thi?? Thanh Tru??c",0,R.drawable.free2,3,0));
        listBookforyou.add(new Books(5,"The one and only","Nguy????n Thi?? Nghi Xu??n",0,R.drawable.free5,4,0));
        listBookforyou.add(new Books(6,"The final six","?????? Thi?? Thanh Tru??c",30000,R.drawable.cost1,5,0));
        listBookforyou.add(new Books(7,"Cold lake","Nguy????n Thi?? Nghi Xu??n",50000,R.drawable.cost2,2,0));
        listBookforyou.add(new Books(3,"Satellite","Nguy????n Thi?? Nghi Xu??n",0,R.drawable.free3,2,0));
        listBookforyou.add(new Books(4,"Last to rise","?????? Thi?? Thanh Tru??c",0,R.drawable.free4,1,0));
        listBookforyou.add(new Books(8,"His life","?????? Thi?? Thanh Tru??c",40000,R.drawable.cost3,3,0));
        listBookforyou.add(new Books(9,"Black moon","Nguy????n Thi?? Nghi Xu??n",50000,R.drawable.cost4,2,0));

        listCategory.add(new Category("Sa??ch da??nh cho ba??n",listBookforyou));
        listCategory.add(new Category("Sa??ch ti??nh phi??",listBookcost));
        listCategory.add(new Category("Sa??ch mi????n phi??",listBookfree));
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
        binding.btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });
    }
}