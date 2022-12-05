package com.K204110582.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.K204110582.adapters.Books;
import com.K204110582.finalapp.databinding.ActivityBookBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    ActivityBookBinding binding;
    public static ArrayList<Books> bookslistreading = new ArrayList<>();
    public static ArrayList<Books> bookslistwishlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
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
                        startActivity(new Intent(getApplicationContext(),UserActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        Bundle bundle = getIntent().getExtras();
        Books books = (Books) bundle.get("books");
        if (books == null) {
            showDataLibrary();
            addEvents1();
            bundle = new Bundle();
        }
        else {
        showDataHome();
        addEvents2();
        }
    }

    private void showDataHome() {
            Bundle bundle = getIntent().getExtras();
            Books books = (Books) bundle.get("books");
            int bookId = books.getBookId();
            String bookName = books.getBookName();
            String author_name = books.getAuthor_name();
            int bookThumb = books.getBookThumb();
            float rating = books.getRating();
            int group_chat_id = books.getGroup_chat_id();
            String source = "1";
            int price = books.getPrice();
            Books bookcheck = new Books(bookId,bookName,author_name,price,bookThumb,rating,group_chat_id);
            if (bookslistwishlist.contains(bookcheck)) {
                binding.btnAddWishlist.setVisibility(View.GONE);
                binding.btnDeleteWishlist.setVisibility(View.VISIBLE);
            }
            else {
                binding.btnDeleteWishlist.setVisibility(View.GONE);
                binding.btnAddWishlist.setVisibility(View.VISIBLE);
            }
            binding.txtBookName.setText(bookName);
            binding.imgBook.setImageResource(bookThumb);
            binding.txtAuthor.setText(author_name);
            if (bookId < 6) {
                binding.txtCategory.setText("Tình cảm lãng mạn");
            }
            else {
                binding.txtCategory.setText("Khoa học viễn tưởng");
            }
            if (price > 0) {
                binding.btnReadnow.setVisibility(View.GONE);
                binding.btnBuynow.setVisibility(View.VISIBLE);
                binding.txtFreeCost.setText(books.getPrice() + " đ");
            }
            else {
                binding.btnReadnow.setVisibility(View.VISIBLE);
                binding.btnBuynow.setVisibility(View.GONE);
                binding.txtFreeCost.setText("Tác phẩm miễn phí");
            }
            binding.ratingBar.setRating(rating);
    }
    private void addEvents2() {
        Bundle bundle = getIntent().getExtras();
        Books books = (Books) bundle.get("books");
        int bookId = books.getBookId();
        String bookName = books.getBookName();
        String author_name = books.getAuthor_name();
        int price = books.getPrice();
        int bookThumb = books.getBookThumb();
        float rating = books.getRating();
        int group_chat_id = books.getGroup_chat_id();
        String source = "1";
        Books bookcheck = new Books(bookId,bookName,author_name,price,bookThumb,rating,group_chat_id);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (source == "0") {
                    Intent intent = new Intent(BookActivity.this,LibraryActivity.class);
                    intent.putExtra("bookname",bookName);
                    intent.putExtra("bookimage",bookThumb);
                    intent.putExtra("bookId",bookId);
                    intent.putExtra("authorname",author_name);
                    intent.putExtra("price",price);
                    intent.putExtra("groupchatid",group_chat_id);
                    intent.putExtra("rating",rating);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(BookActivity.this,MainActivity.class);
                    intent.putExtra("bookname",bookName);
                    intent.putExtra("bookimage",bookThumb);
                    intent.putExtra("bookId",bookId);
                    intent.putExtra("authorname",author_name);
                    intent.putExtra("price",price);
                    intent.putExtra("groupchatid",group_chat_id);
                    intent.putExtra("rating",rating);
                    startActivity(intent);
                }
            }
        });
        binding.btnReadnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookActivity.this,BookReadingActivity.class);
                intent.putExtra("bookname",bookName);
                intent.putExtra("bookimage",bookThumb);
                intent.putExtra("bookId",bookId);
                intent.putExtra("authorname",author_name);
                intent.putExtra("price",price);
                intent.putExtra("groupchatid",group_chat_id);
                intent.putExtra("rating",rating);
                intent.putExtra("source",source);
                if (!bookslistreading.contains(bookcheck)){
                    bookslistreading.add(bookcheck);
                }
                startActivity(intent);
            }
        });
        binding.btnBuynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookActivity.this,PaymentActivity.class);
                intent.putExtra("bookname",bookName);
                intent.putExtra("bookimage",bookThumb);
                intent.putExtra("bookId",bookId);
                intent.putExtra("authorname",author_name);
                intent.putExtra("price",price);
                intent.putExtra("groupchatid",group_chat_id);
                intent.putExtra("rating",rating);
                intent.putExtra("source",source);
                startActivity(intent);
            }
        });
        binding.btnAddWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookslistwishlist.add(bookcheck);
                binding.btnDeleteWishlist.setVisibility(View.VISIBLE);
                binding.btnAddWishlist.setVisibility(View.GONE);
            }
        });
        binding.btnDeleteWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookslistwishlist.remove(bookcheck);
                binding.btnDeleteWishlist.setVisibility(View.GONE);
                binding.btnAddWishlist.setVisibility(View.VISIBLE);
            }
        });
    }

    private void showDataLibrary() {
            String text =  binding.txtBookName.getText().toString();
            Intent intent = getIntent();
            int bookId = intent.getIntExtra("bookId",0);
            String bookName = intent.getStringExtra("bookname");
            String author_name = intent.getStringExtra("authorname");
            int price = intent.getIntExtra("price",0);
            int bookThumb = intent.getIntExtra("bookimage",R.drawable.free1);
            float rating = intent.getFloatExtra("rating",0f);
            int group_chat_id = intent.getIntExtra("groupchatid",0);
            String source = "0";
            Books bookcheck = new Books(bookId,bookName,author_name,price,bookThumb,rating,group_chat_id);
            if (bookslistwishlist.contains(bookcheck)) {
                binding.btnAddWishlist.setVisibility(View.GONE);
                binding.btnDeleteWishlist.setVisibility(View.VISIBLE);
            }
            else {
                binding.btnDeleteWishlist.setVisibility(View.GONE);
                binding.btnAddWishlist.setVisibility(View.VISIBLE);
            }
            binding.txtBookName.setText(bookName);
            binding.imgBook.setImageResource(bookThumb);
            binding.txtAuthor.setText(author_name);
            if (bookId < 6) {
                binding.txtCategory.setText("Tình cảm lãng mạn");
            }
            else {
                binding.txtCategory.setText("Khoa học viễn tưởng");
            }
            if (price > 0) {
                binding.btnReadnow.setVisibility(View.GONE);
                binding.btnBuynow.setVisibility(View.VISIBLE);
                binding.txtFreeCost.setText(price + " đ");
            }
            else {
                binding.btnReadnow.setVisibility(View.VISIBLE);
                binding.btnBuynow.setVisibility(View.GONE);
                binding.txtFreeCost.setText("Tác phẩm miễn phí");
            }
            binding.ratingBar.setRating(rating);
    }
    private void addEvents1() {
        Intent intent = getIntent();
        int bookId = intent.getIntExtra("bookId",0);
        String bookName = intent.getStringExtra("bookname");
        String author_name = intent.getStringExtra("authorname");
        int price = intent.getIntExtra("price",0);
        int bookThumb = intent.getIntExtra("bookimage",R.drawable.free1);
        float rating = intent.getFloatExtra("rating",0f);
        int group_chat_id = intent.getIntExtra("groupchatid",0);
        String source = "0";
        Books bookcheck = new Books(bookId,bookName,author_name,price,bookThumb,rating,group_chat_id);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (source == "0") {
                    Intent intent = new Intent(BookActivity.this,LibraryActivity.class);
                    intent.putExtra("bookname",bookName);
                    intent.putExtra("bookimage",bookThumb);
                    intent.putExtra("bookId",bookId);
                    intent.putExtra("authorname",author_name);
                    intent.putExtra("price",price);
                    intent.putExtra("groupchatid",group_chat_id);
                    intent.putExtra("rating",rating);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(BookActivity.this,MainActivity.class);
                    intent.putExtra("bookname",bookName);
                    intent.putExtra("bookimage",bookThumb);
                    intent.putExtra("bookId",bookId);
                    intent.putExtra("authorname",author_name);
                    intent.putExtra("price",price);
                    intent.putExtra("groupchatid",group_chat_id);
                    intent.putExtra("rating",rating);
                    startActivity(intent);
                }
            }
        });
        binding.btnReadnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(BookActivity.this,BookReadingActivity.class);
                    intent.putExtra("bookname",bookName);
                    intent.putExtra("bookimage",bookThumb);
                    intent.putExtra("bookId",bookId);
                    intent.putExtra("authorname",author_name);
                    intent.putExtra("price",price);
                    intent.putExtra("groupchatid",group_chat_id);
                    intent.putExtra("rating",rating);
                    intent.putExtra("source",source);
                    if (!bookslistreading.contains(bookcheck)){
                        bookslistreading.add(bookcheck);
                    }
                    startActivity(intent);
            }
        });
        binding.btnBuynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookActivity.this,PaymentActivity.class);
                intent.putExtra("bookname",bookName);
                intent.putExtra("bookimage",bookThumb);
                intent.putExtra("bookId",bookId);
                intent.putExtra("authorname",author_name);
                intent.putExtra("price",price);
                intent.putExtra("groupchatid",group_chat_id);
                intent.putExtra("rating",rating);
                intent.putExtra("source",source);
                startActivity(intent);
            }
        });
        binding.btnAddWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookslistwishlist.add(bookcheck);
                binding.btnDeleteWishlist.setVisibility(View.VISIBLE);
                binding.btnAddWishlist.setVisibility(View.GONE);
            }
        });
        binding.btnDeleteWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookslistwishlist.remove(bookcheck);
                binding.btnDeleteWishlist.setVisibility(View.GONE);
                binding.btnAddWishlist.setVisibility(View.VISIBLE);
            }
        });
    }

}
