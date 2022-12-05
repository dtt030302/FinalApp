package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.K204110582.finalapp.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {
    ActivityPaymentBinding binding;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    String[] items = {"VNPay","Thẻ ATM / Internet Banking","Thẻ tín dụng (Credit card) / Thẻ ghi nợ (Debit card)","MoMo","ZaloPay","ShopeePay"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        adapterItems = new ArrayAdapter<>(this,R.layout.drop_down_item,items);
        autoCompleteTextView.setAdapter(adapterItems);
        showData();
        addEvents();
    }

    private void showData() {
        Intent intent = getIntent();
        int bookId = intent.getIntExtra("bookId",0);
        String bookName = intent.getStringExtra("bookname");
        String author_name = intent.getStringExtra("authorname");
        int price = intent.getIntExtra("price",0);
        int bookThumb = intent.getIntExtra("bookimage",R.drawable.free1);
        float rating = intent.getFloatExtra("rating",0f);
        int group_chat_id = intent.getIntExtra("groupchatid",0);
        binding.imgBook.setImageResource(bookThumb);
        binding.txtAuthor.setText("Tác giả: " + author_name);
        binding.txtBookName.setText(bookName);
        binding.txtPrice.setText(price + " đ");
        binding.txt1.setText(price + " đ");
        binding.txt2.setText(price + " đ");
        binding.txt3.setText(price + " đ");
    }

    private void addEvents() {
        Intent intent = getIntent();
        int bookId = intent.getIntExtra("bookId",0);
        String bookName = intent.getStringExtra("bookname");
        String author_name = intent.getStringExtra("authorname");
        int price = intent.getIntExtra("price",0);
        int bookThumb = intent.getIntExtra("bookimage",R.drawable.free1);
        float rating = intent.getFloatExtra("rating",0f);
        int group_chat_id = intent.getIntExtra("groupchatid",0);
        int source = intent.getIntExtra("source",0);
        binding.autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });
        String text = autoCompleteTextView.getText().toString();
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.equals(""))
                {
                    Toast.makeText(PaymentActivity.this, "Vui lòng chọn phương thức thanh toán" , Toast.LENGTH_LONG).show();
                }
                else {
                    binding.linear.setVisibility(View.GONE);
                    binding.linearDone.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            Intent intent = new Intent(PaymentActivity.this,BookActivity.class);
                            intent.putExtra("bookname",bookName);
                            intent.putExtra("bookimage",bookThumb);
                            intent.putExtra("bookId",bookId);
                            intent.putExtra("authorname",author_name);
                            intent.putExtra("groupchatid",group_chat_id);
                            intent.putExtra("rating",rating);
                            intent.putExtra("price",0);
                            intent.putExtra("source",source);
                            startActivity(intent);
                        }
                    }, 2000);
                }
            }
        });
    }
}