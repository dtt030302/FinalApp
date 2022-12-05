package com.K204110582.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.K204110582.finalapp.BookActivity;
import com.K204110582.finalapp.MainActivity;
import com.K204110582.finalapp.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Books> mBooks;
    private Context mContext;

    public void setData(Context context,List<Books> list) {
        this.mBooks = list;
        this.mContext = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        final Books books = mBooks.get(position);
        if (mBooks == null) {
            return;
        }
        holder.img.setImageResource(books.getBookThumb());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGotoBookDetail(books);
            }
        });
    }

    private void onClickGotoBookDetail(Books books) {
        Intent intent = new Intent(mContext,BookActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("books", books);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public void release() {
        mContext = null;
    }

    @Override
    public int getItemCount() {
        if(mBooks != null){
            return mBooks.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout layoutItem;

        private ImageView img;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            img = itemView.findViewById(R.id.imageView);
        }
    }
}
