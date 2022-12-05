package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.K204110582.finalapp.databinding.ActivityBookReadingBinding;

public class BookReadingActivity extends AppCompatActivity {
    ActivityBookReadingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_book_reading);
        binding = ActivityBookReadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showData();
        addEvents();
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
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookReadingActivity.this,RatingActivity.class);
                intent.putExtra("bookname",bookName);
                intent.putExtra("authorname",author_name);
                intent.putExtra("bookimage",bookThumb);
                intent.putExtra("rating",rating);
                String author_name = intent.getStringExtra("authorname");
                int bookThumb = intent.getIntExtra("bookimage",R.drawable.free1);
                float rating = intent.getFloatExtra("rating",0f);
                startActivity(intent);
            }
        });
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
        binding.ratingBar.setRating(rating);
        binding.txtAuthor.setText(author_name);
        binding.txtBookName.setText(bookName);
        if (bookId == 1) {
            binding.txtContent.setText(R.string.free1);
        }
        else {
            if (bookId == 2) {
                binding.txtContent.setText(R.string.free2);
            }
            else {
                if (bookId == 3) {
                    binding.txtContent.setText(R.string.free3);
                }
                else {
                    if (bookId == 4) {
                        binding.txtContent.setText(R.string.free4);
                    }
                    else {
                        if (bookId == 5) {
                            binding.txtContent.setText(R.string.free5);
                        }
                        else {
                            if (bookId == 6) {
                                binding.txtContent.setText(R.string.cost1);
                            }
                            else {
                                if (bookId == 1) {
                                    binding.txtContent.setText(R.string.cost2);
                                }
                                else {
                                    if (bookId == 1) {
                                        binding.txtContent.setText(R.string.cost3);
                                    }
                                    else {
                                        if (bookId == 1) {
                                            binding.txtContent.setText(R.string.cost4);
                                        }
                                        else {
                                            if (bookId == 1) {
                                                binding.txtContent.setText(R.string.cost5);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}