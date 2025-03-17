package com.library;

import java.time.LocalDate;

public class Book {
    private LocalDate published;
    private String author;
    private String title;

    public Book(String title, String author, LocalDate published){
        this.author = author; this.title = title; this.published = published;
    }

    public String getAuthor() {
        return author;
    }
    
    public LocalDate getPublished() {
        return published;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " by " + author + ", published in " + published;
    }
}
