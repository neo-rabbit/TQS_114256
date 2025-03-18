package com.library;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Library
{
    private List<Book> store = new LinkedList<>();

    public List<Book> findBooksByAuthor(String author){
        List<Book> queryRes = new LinkedList<>();
        for (Book book : store) {
            if (book.getAuthor().equals(author)){
                queryRes.add(book);
            }
        }
        return queryRes;
    }

    public void addBook(Book book){
        store.add(book);
    }

    public List<Book> findBooks(LocalDate minDate, LocalDate maxDate){
        List<Book> queryRes = new LinkedList<>();
        for (Book book : store) {
            if (book.getPublished().isAfter(minDate) && book.getPublished().isBefore(maxDate)){
                queryRes.add(book);
            }
        }
        return queryRes;
    }
}
