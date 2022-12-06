package com.K204110582.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.K204110582.finalapp.databinding.ActivityMainBinding;
import com.K204110582.finalapp.databinding.ActivityUserBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity {
    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_user);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.user);
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
                        startActivity(new Intent(getApplicationContext(),ChatActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.user:
                        return true;
                }
                return false;
            }
        });
        showData();
        addEvents();
    }

    private void showData() {
        Intent intent = getIntent();
        String text = intent.getStringExtra("email");
        String text1 = intent.getStringExtra("tdn");
        String text2 = intent.getStringExtra("hovaten");
        if (TextUtils.isEmpty(text)) {
        }
        else {
            binding.txtEmail.setText(text);
        }
        if (TextUtils.isEmpty(text1)) {
        }
        else {
            binding.txtUserName.setText(text1);
        }
        binding.hovaten.setText(text2);
    }

    private void addEvents() {
        Intent intent = getIntent();
        String text1 = binding.txtUserName.getText().toString();
        String text = binding.txtEmail.getText().toString();
        String text2 = binding.hovaten.getText().toString();
        binding.btnPersonalInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,UserInformationActivity.class);
                intent.putExtra("email",text);
                intent.putExtra("tdn",text1);
                intent.putExtra("hovaten",text2);
                startActivity(intent);
            }
        });
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(WaitActivity.PREFS_NAME,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("hasLoggedIn",false);
                editor.apply();
                Intent intent = new Intent(UserActivity.this,StartActivity.class);
                startActivity(intent);
            }
        });
    }
}