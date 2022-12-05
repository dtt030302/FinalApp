package com.K204110582.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.K204110582.finalapp.ChatScreenActivity;
import com.K204110582.finalapp.R;

import java.util.List;

public class ChatAdapter extends BaseAdapter {
    Activity activity;
    int book_layout;
    List<Books> books;

    public ChatAdapter(Activity activity, int book_layout, List<Books> books) {
        this.activity = activity;
        this.book_layout = book_layout;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ReadingAdapter.ViewHolder holder;
        if (view == null){
            holder = new ReadingAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(book_layout,null);
            holder.imvThumb = view.findViewById(R.id.imv_chat);
            holder.txtAuthor = view.findViewById(R.id.txt_Author);
            holder.txtBook = view.findViewById(R.id.txt_Book);
            view.setTag(holder);
        }
        else {
            holder = (ReadingAdapter.ViewHolder) view.getTag();
        }

        Books t = books.get(position);
        holder.imvThumb.setImageResource(t.getBookThumb());
        Books b = books.get(position);
        holder.txtBook.setText(b.getBookName());
        Books a = books.get(position);
        holder.txtAuthor.setText(a.getAuthor_name());
        return view;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView message;
        public ViewHolder(View itemView){
            super(itemView);
            this.message = itemView.findViewById(R.id.message_body);
        }
    }
}
