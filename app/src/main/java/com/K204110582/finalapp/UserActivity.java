package com.K204110582.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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

import java.io.ByteArrayOutputStream;

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

    public void showAlertDialog(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Xác nhận đăng xuất");
        alert.setMessage("Bạn có muốn đăng xuất không ?");
        alert.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences sharedPreferences = getSharedPreferences(WaitActivity.PREFS_NAME,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("hasLoggedIn",false);
                editor.apply();
                Intent intent = new Intent(UserActivity.this,StartActivity.class);
                startActivity(intent);
            }
        });
        alert.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.create().show();
    }

    private void showData() {
        Intent intent = getIntent();
        String text = intent.getStringExtra("email");
        String text1 = intent.getStringExtra("tdn");
        String text2 = intent.getStringExtra("hovaten");
        byte[] byteArray = getIntent().getByteArrayExtra("avt");
        if (byteArray != null) {
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            binding.avtPic.setImageBitmap(bmp);
        }
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
                byte[] byteArray = getIntent().getByteArrayExtra("avt");
                if (byteArray != null) {
                    Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    binding.avtPic.setImageBitmap(bmp);
                }
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
        binding.helpUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,SupportActivity.class);
                startActivity(intent);
            }
        });
        binding.displayUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,ViewActivity.class);
                startActivity(intent);
            }
        });
        binding.paymentUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, PaymentTypeActivity.class);
                startActivity(intent);
            }
        });
        binding.languageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,LanguageActivity.class);
                startActivity(intent);
            }
        });
        binding.notiUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });
        binding.privacyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,PrivacyActivity.class);
                startActivity(intent);
            }
        });
        binding.securityUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, SecurityActivity.class);
                startActivity(intent);
            }
        });
        binding.btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });
    }
}