package com.github.mpalambonisi;
import java.util.HashMap;
import java.util.Map;

public class LibraryRepository {
    private Map<Integer, Book> bookDatabase = new HashMap<>();

    public void addBook(Book book){
        bookDatabase.put(book.getId(), book);
    }
    public Book removeBook(int bookId){
        return bookDatabase.remove(bookId);
    }

    public Book findBookById(int bookId){
        return bookDatabase.get(bookId);
    }

    public Map<Integer, Book> getAllBooks(){
        return bookDatabase;
    }

    public boolean isLibraryEmpty(){
        return bookDatabase.isEmpty();
    }

}
