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

import com.K204110582.finalapp.R;

import java.util.List;

public class ReadingAdapter extends BaseAdapter {
    Activity activity;
    int book_layout;
    List<Books> books;

    public ReadingAdapter(Activity activity, int book_layout, List<Books> books) {
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
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(book_layout,null);
            holder.imvThumb = view.findViewById(R.id.imageView);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        Books b = books.get(position);
        holder.imvThumb.setImageResource(b.getBookThumb());
        return view;
    }

    public static class ViewHolder{
        TextView txtBook, txtAuthor;
        ImageView imvThumb;
    }
}
