package com.K204110582.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.K204110582.adapters.Books;
import com.K204110582.adapters.ChatAdapter;
import com.K204110582.adapters.ReadingAdapter;
import com.K204110582.finalapp.databinding.ActivityChatBinding;
import com.K204110582.finalapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    ActivityChatBinding binding;
    ChatAdapter chatAdapter;
    ArrayList<Books> chatslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.chat);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.library:
                        startActivity(new Intent(getApplicationContext(),LibraryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.chat:
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),UserActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        loadChatdata();
        addEvents();
    }

    private void addEvents() {
        binding.lvChat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ChatActivity.this,ChatScreenActivity.class);
                intent.putExtra("chattext",chatslist.get(position).getBookName());
                intent.putExtra("chatimage",chatslist.get(position).getBookThumb());
                startActivity(intent);
            }
        });
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadChatdata() {
        chatslist = new ArrayList<>();
        chatslist.add(new Books(1,"Sensation","Nguyễn Thị Nghi Xuân",0,R.drawable.free1,4,1));
        chatslist.add(new Books(2,"The past is rising","Đỗ Thị Thanh Trúc",0,R.drawable.free2,3,2));
        chatslist.add(new Books(3,"Satellite","Nguyễn Thị Nghi Xuân",0,R.drawable.free3,2,3));
        chatslist.add(new Books(4,"Last to rise","Đỗ Thị Thanh Trúc",0,R.drawable.free4,1,4));
        chatslist.add(new Books(5,"The one and only","Nguyễn Thị Nghi Xuân",0,R.drawable.free5,4,5));
        chatAdapter = new ChatAdapter(ChatActivity.this,R.layout.list_layout,chatslist);
        binding.lvChat.setAdapter(chatAdapter);
    }
}