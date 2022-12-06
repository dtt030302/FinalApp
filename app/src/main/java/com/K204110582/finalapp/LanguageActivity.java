package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.K204110582.finalapp.databinding.ActivityLanguageBinding;

public class LanguageActivity extends AppCompatActivity {
    ActivityLanguageBinding binding;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    String[] items = {"Tiếng Việt", "Tiếng Anh", "Tiếng Trung", "Tiếng Thái", "Tiếng Nhật"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        adapterItems = new ArrayAdapter<>(this,R.layout.drop_down_item,items);
        autoCompleteTextView.setAdapter(adapterItems);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (autoCompleteTextView.getText().toString().equals("Tiếng Việt")) {
                    Toast.makeText(LanguageActivity.this,"Đã chọn ngôn ngữ tiếng Việt",Toast.LENGTH_SHORT).show();
                    binding.language.setText("Ngôn ngữ");
                    binding.choose.setText("Lựa chọn ngôn ngữ");
                    binding.hint.setHint("Chọn ngôn ngữ");
                }
                else {
                    if (autoCompleteTextView.getText().toString().equals("Tiếng Anh")) {
                        Toast.makeText(LanguageActivity.this,"English language selected",Toast.LENGTH_SHORT).show();
                        binding.language.setText("Language");
                        binding.choose.setText("Language selection");
                        binding.hint.setHint("Language selection");
                    }
                    else {
                        if (autoCompleteTextView.getText().toString().equals("Tiếng Nhật")) {
                            Toast.makeText(LanguageActivity.this,"日本語が選択されました",Toast.LENGTH_SHORT).show();
                            binding.language.setText("言語");
                            binding.choose.setText("言語選択");
                            binding.hint.setHint("言語選択");
                        }
                        else {
                            if (autoCompleteTextView.getText().toString().equals("Tiếng Trung")) {
                                Toast.makeText(LanguageActivity.this,"已选择中文",Toast.LENGTH_SHORT).show();
                                binding.language.setText("语");
                                binding.choose.setText("การเลือกภาษา");
                                binding.hint.setHint("การเลือกภาษา");
                            }
                            else {
                                if (autoCompleteTextView.getText().toString().equals("Tiếng Thái")) {
                                    Toast.makeText(LanguageActivity.this,"เลือกภาษาไทยแล้ว",Toast.LENGTH_SHORT).show();
                                    binding.language.setText("ภาษา");
                                    binding.choose.setText("การเลือกภาษา");
                                    binding.hint.setHint("การเลือกภาษา");
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}