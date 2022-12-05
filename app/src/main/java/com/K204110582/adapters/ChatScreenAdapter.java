package com.K204110582.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.K204110582.finalapp.R;
import com.K204110582.models.ChatModel;

import java.util.ArrayList;

public class ChatScreenAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private ArrayList<ChatModel> chatModels;
    private Context context;

    public ChatScreenAdapter(ArrayList<ChatModel> chatModels, Context context) {
        this.chatModels = chatModels;
        this.context = context;
    }


    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.my_message,parent, false);
        ChatAdapter.ViewHolder holder = new ChatAdapter.ViewHolder(listItem);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        holder.message.setText(chatModels.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return chatModels.size();
    }
}
