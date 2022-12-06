package com.K204110582.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.K204110582.finalapp.databinding.ActivityUserInformationBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class UserInformationActivity extends AppCompatActivity {
    ActivityUserInformationBinding binding;
    final Calendar myCalendar = Calendar.getInstance();
    EditText editText;
    ImageView imageView;
    LinearLayout linearLayout;
    public static final int PERMISSION_REQUEST = 0;
    public static final int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M || checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSION_REQUEST);
        }

        editText = findViewById(R.id.edt_birth);
        imageView = findViewById(R.id.img_avatar);
        linearLayout = findViewById(R.id.avatar);
        showData();
        addEvents();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_LOAD_IMAGE:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePatheColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePatheColumn,null,null,null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePatheColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                }
        }
    }

    private void updateLabel() {
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void addEvents() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        binding.edtBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(UserInformationActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        binding.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,RESULT_LOAD_IMAGE);
            }
        });
    }

    private void showData() {
        Intent intent = getIntent();
        String text = intent.getStringExtra("email");
        String text1 = intent.getStringExtra("tdn");
        String text2 = intent.getStringExtra("hovaten");
        if (!TextUtils.isEmpty(text1)) {
            binding.edtMail.setText(text);
            binding.edtMail.setFocusable(false);
            binding.edtMail.setFocusableInTouchMode(false);
            binding.edtMail.setClickable(false);
            binding.edtMail.setBackgroundColor(Color.TRANSPARENT);
        }
        if (!TextUtils.isEmpty(text2)) {
            binding.edtTdn.setText(text1);
            binding.edtTdn.setFocusable(false);
            binding.edtTdn.setFocusableInTouchMode(false);
            binding.edtTdn.setClickable(false);
            binding.edtTdn.setBackgroundColor(Color.TRANSPARENT);
        }
        if (!TextUtils.isEmpty(text2)) {
            binding.edtName.setText(text2);
            binding.edtName.setFocusable(false);
            binding.edtName.setFocusableInTouchMode(false);
            binding.edtName.setClickable(false);
            binding.edtName.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}