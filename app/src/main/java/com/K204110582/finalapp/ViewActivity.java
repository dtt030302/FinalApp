package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.K204110582.finalapp.databinding.ActivityViewBinding;

public class ViewActivity extends AppCompatActivity {
    ActivityViewBinding binding;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    String[] items = {"Giao diện sáng", "Giao diện tối"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
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
                if (autoCompleteTextView.getText().toString().equals("Giao diện sáng")) {
                    Toast.makeText(ViewActivity.this,"Đã chọn giao diện sáng",Toast.LENGTH_SHORT).show();
                    binding.bigBg.setBackgroundResource(R.color.main_lightest);
                    binding.btnBack.setBackgroundTintList(getColorStateList(R.color.main_darkest));
                    binding.choose.setTextColor(getColor(R.color.main_darkest));
                    binding.tieude.setTextColor(getColor(R.color.main_darkest));
                    binding.autoCompleteTextView.setTextColor(getColor(R.color.main_darkest));
                    binding.btnBack.setBackgroundColor(getResources().getColor(R.color.main_lightest));
                    binding.hint.setBackgroundColor(getColor(R.color.main_lightest));
                    binding.autoCompleteTextView.setBackgroundColor(getColor(R.color.main_lightest));
                    binding.hint.setHintTextColor(ColorStateList.valueOf(getColor(R.color.main_darkest)));
                }
                else {
                    if (autoCompleteTextView.getText().toString().equals("Giao diện tối")) {
                        Toast.makeText(ViewActivity.this,"Đã chọn giao diện tối",Toast.LENGTH_SHORT).show();
                        binding.bigBg.setBackgroundResource(R.color.main_dark);
                        binding.btnBack.setBackgroundTintList(getColorStateList(R.color.main_lightest));
                        binding.choose.setTextColor(getColor(R.color.main_lightest));
                        binding.tieude.setTextColor(getColor(R.color.main_lightest));
                        binding.autoCompleteTextView.setTextColor(getColor(R.color.main_lightest));
                        binding.btnBack.setBackgroundColor(getColor(R.color.main_darkest));
                        binding.hint.setBackgroundColor(getColor(R.color.main_darkest));
                        binding.autoCompleteTextView.setBackgroundColor(getColor(R.color.main_darkest));
                        binding.hint.setHintTextColor(ColorStateList.valueOf(getColor(R.color.main_lightest)));
                    }
                }
                }
        });
    }
}