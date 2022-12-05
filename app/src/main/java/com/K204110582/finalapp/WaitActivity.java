package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.K204110582.finalapp.databinding.ActivityWaitBinding;

public class WaitActivity extends AppCompatActivity {
    ActivityWaitBinding binding;
    private static int SPLASH_TIME_OUT=1000;
    public static String PREFS_NAME= "hasLoggedIn";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWaitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(WaitActivity.PREFS_NAME,0);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);
                if (!hasLoggedIn) {
                    Intent intent = new Intent(WaitActivity.this,StartActivity.class);
                    startActivity(intent);
                    sharedPreferences = getSharedPreferences(WaitActivity.PREFS_NAME,0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("hasLoggedIn",true);
                    finish();
                }
                else {
                    Intent intent = new Intent(WaitActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}