package com.K204110582.finalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.K204110582.adapters.ChatAdapter;
import com.K204110582.adapters.ChatScreenAdapter;
import com.K204110582.finalapp.databinding.ActivityChatBinding;
import com.K204110582.finalapp.databinding.ActivityChatScreenBinding;
import com.K204110582.models.ChatModel;

import java.util.ArrayList;

public class ChatScreenActivity extends AppCompatActivity {
    ActivityChatScreenBinding binding;
    private RecyclerView recyclerView;
    private EditText messagebox;
    private Button btnSend;
    final ArrayList<ChatModel> chatModels = new ArrayList<>();
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_chat_screen);
        binding = ActivityChatScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = findViewById(R.id.chat_list);
        messagebox = findViewById(R.id.et_chat_box);
        btnSend = findViewById(R.id.btn_chat_send);
        showData();
        addEvents();
    }

    private void showData() {
        Intent intent = getIntent();
        String text = intent.getStringExtra("chattext");
        int img = intent.getIntExtra("chatimage",R.drawable.free1);
        binding.txtChat.setText(text);
        binding.imgChat.setImageResource(img);
    }

    private void addEvents() {
        binding.btnChatback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                ChatModel chatModel = new ChatModel();
                chatModel.setId(i);
                chatModel.setMe(true);
                chatModel.setMessage(messagebox.getText().toString().trim());
                chatModels.add(chatModel);

                ChatScreenAdapter chatScreenAdapter = new ChatScreenAdapter(chatModels,ChatScreenActivity.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(ChatScreenActivity.this));
                recyclerView.setAdapter(chatScreenAdapter);
                messagebox.setText("");
            }
        });
    }
}