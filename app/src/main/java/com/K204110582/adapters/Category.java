package com.K204110582.adapters;

import java.util.List;

public class Category {

    private String nameCategory;
    private List<Books> books;

    public Category(String nameCategory, List<Books> books) {
        this.nameCategory = nameCategory;
        this.books = books;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
