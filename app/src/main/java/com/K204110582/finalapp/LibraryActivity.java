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
    ArrayList<Books> bookslist1;
    ArrayList<Books> bookslist2;

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
        bookslist1 = new ArrayList<>();
        bookslist1.add(new Books(1,"Sensation","Nguyễn Thị Nghi Xuân",0,R.drawable.free1,4,1));
        bookslist1.add(new Books(2,"The past is rising","Đỗ Thị Thanh Trúc",0,R.drawable.free2,3,2));
        bookslist1.add(new Books(3,"Satellite","Nguyễn Thị Nghi Xuân",0,R.drawable.free3,2,3));
        bookslist1.add(new Books(4,"Last to rise","Đỗ Thị Thanh Trúc",0,R.drawable.free4,1,4));
        bookslist1.add(new Books(5,"The one and only","Nguyễn Thị Nghi Xuân",0,R.drawable.free5,4,5));
        readingAdapter1 = new ReadingAdapter(LibraryActivity.this,R.layout.grid_library_layout,bookslist1);
        binding.gridReading.setAdapter(readingAdapter1);
        bookslist2 = new ArrayList<>();
        bookslist2.add(new Books(6,"The final six","Đỗ Thị Thanh Trúc",30000,R.drawable.cost1,5,6));
        bookslist2.add(new Books(7,"Cold lake","Nguyễn Thị Nghi Xuân",50000,R.drawable.cost2,2,7));
        bookslist2.add(new Books(8,"His life","Đỗ Thị Thanh Trúc",40000,R.drawable.cost3,3,8));
        bookslist2.add(new Books(9,"Black moon","Nguyễn Thị Nghi Xuân",50000,R.drawable.cost4,2,9));
        bookslist2.add(new Books(10,"This is not the end","Nguyễn Thị Nghi Xuân",70000,R.drawable.cost5,3,10));
        readingAdapter2 = new ReadingAdapter(LibraryActivity.this,R.layout.grid_library_layout,bookslist2);
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
                intent.putExtra("bookname",bookslist1.get(position).getBookName());
                intent.putExtra("bookimage",bookslist1.get(position).getBookThumb());
                intent.putExtra("bookId",bookslist1.get(position).getBookId());
                intent.putExtra("authorname",bookslist1.get(position).getAuthor_name());
                intent.putExtra("price",bookslist1.get(position).getPrice());
                intent.putExtra("groupchatid",bookslist1.get(position).getGroup_chat_id());
                intent.putExtra("rating",bookslist1.get(position).getRating());
                intent.putExtra("source",0);
                startActivity(intent);
            }
        });
        binding.gridWishlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LibraryActivity.this,BookActivity.class);
                intent.putExtra("bookname",bookslist2.get(position).getBookName());
                intent.putExtra("bookimage",bookslist2.get(position).getBookThumb());
                intent.putExtra("bookId",bookslist2.get(position).getBookId());
                intent.putExtra("authorname",bookslist2.get(position).getAuthor_name());
                intent.putExtra("price",bookslist2.get(position).getPrice());
                intent.putExtra("groupchatid",bookslist2.get(position).getGroup_chat_id());
                intent.putExtra("rating",bookslist2.get(position).getRating());
                intent.putExtra("source",0);
                startActivity(intent);
            }
        });
    }
}