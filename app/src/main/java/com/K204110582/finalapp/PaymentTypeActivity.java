package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.K204110582.finalapp.databinding.ActivityPaymentTypeBinding;

public class PaymentTypeActivity extends AppCompatActivity {
    ActivityPaymentTypeBinding binding;
    public static String momo;
    public static String shopee;
    public static String vnpay;
    public static String zalopay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_payment_type);
        binding = ActivityPaymentTypeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showData();
        addEvents();
    }

    private void showData() {
        binding.momo.setText(PaymentTypeActivity.momo);
        binding.vnpay.setText(PaymentTypeActivity.vnpay);
        binding.zalopay.setText(PaymentTypeActivity.zalopay);
        binding.shopeepay.setText(PaymentTypeActivity.shopee);
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
                 PaymentTypeActivity.momo = binding.momo.getText().toString();
                PaymentTypeActivity.shopee = binding.shopeepay.getText().toString();
                PaymentTypeActivity.vnpay = binding.vnpay.getText().toString();
                PaymentTypeActivity.zalopay = binding.zalopay.getText().toString();
                 Toast.makeText(PaymentTypeActivity.this,"Lưu thông tin thanh toán thành công",Toast.LENGTH_SHORT).show();
            }
        });
    }
}