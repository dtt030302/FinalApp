package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.K204110582.finalapp.databinding.ActivityPaymentTypeBinding;

public class PaymentTypeActivity extends AppCompatActivity {
    ActivityPaymentTypeBinding binding;
    public String momo;
    public String shopee;
    public String vnpay;
    public String zalopay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_payment_type);
        binding = ActivityPaymentTypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 momo = binding.momo.getText().toString();
                 shopee = binding.shopeepay.getText().toString();
                 vnpay = binding.shopeepay.getText().toString();
                 zalopay = binding.zalopay.getText().toString();
            }
        });
    }
}