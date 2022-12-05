package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import com.K204110582.finalapp.databinding.ActivityRatingBinding;

public class RatingActivity extends AppCompatActivity {
    ActivityRatingBinding binding;
    RatingBar ratingBar;

    float myRating = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRatingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ratingBar = findViewById(R.id.ratingBar);
        getData();
        addEvents();
        //setContentView(R.layout.activity_rating);
    }

    private void addEvents() {
        binding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int) v;
                String message = null;

                myRating = ratingBar.getRating();
                    switch (rating) {
                        case 1:
                            message = "Rất xin lỗi vì trải nghiệm không tốt";
                            break;
                        case 2:
                            message = "BTalk chân thành xin lỗi";
                            break;
                        case 3:
                            message = "BTalk sẽ nỗ lực để trải nghiệm của bạn trở nên tốt hơn";
                            break;
                        case 4:
                            message = "Cảm ơn bạn đã đánh giá";
                            break;
                        case 5:
                            message = "Bạn là người hùng của BTalk";
                            break;
                    }

                Toast.makeText(RatingActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RatingActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getData() {
        Intent intent = getIntent();
        String bookName = intent.getStringExtra("bookname");
        String author_name = intent.getStringExtra("authorname");
        int bookThumb = intent.getIntExtra("bookimage",R.drawable.free1);
        binding.imgBook.setImageResource(bookThumb);
        binding.txtAuthor.setText("Tác giả: " + author_name);
        binding.txtBookName.setText(bookName);
    }
}