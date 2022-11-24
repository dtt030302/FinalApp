package com.K204110582.adapters;

public class Books {
    int bookId;
    String bookName;
    int author_id;
    int price;
    int bookThumb;
    double rating;
    int group_chat_id;

    public Books(int bookId, String bookName, int author_id, int price, int bookThumb, double rating, int group_chat_id) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author_id = author_id;
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

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getGroup_chat_id() {
        return group_chat_id;
    }

    public void setGroup_chat_id(int group_chat_id) {
        this.group_chat_id = group_chat_id;
    }
}
