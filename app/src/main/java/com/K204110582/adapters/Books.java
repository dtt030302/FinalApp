package com.K204110582.adapters;

import java.io.Serializable;

public class Books implements Serializable {
    int bookId;
    String bookName;
    String author_name;
    int price;
    int bookThumb;
    float rating;
    int group_chat_id;

    public Books(int bookId, String bookName, String author_name, int price, int bookThumb, float rating, int group_chat_id) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author_name = author_name;
        this.price = price;
        this.bookThumb = bookThumb;
        this.rating = rating;
        this.group_chat_id = group_chat_id;
    }
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBookThumb() {
        return bookThumb;
    }

    public void setBookThumb(int bookThumb) {
        this.bookThumb = bookThumb;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getGroup_chat_id() {
        return group_chat_id;
    }

    public void setGroup_chat_id(int group_chat_id) {
        this.group_chat_id = group_chat_id;
    }
}
