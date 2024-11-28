package com.github.mpalambonisi;

import java.util.Map;

public interface LibraryServiceable {
    void addBook(Book book);
    Book findBookById(int id);
    Book removeBook(int id);
    Map<Integer, Book> getAllBooks();
}
