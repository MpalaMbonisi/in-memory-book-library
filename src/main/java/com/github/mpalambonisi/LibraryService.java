package com.github.mpalambonisi;

import java.util.Map;

public class LibraryService implements LibraryServiceable {
    private final LibraryRepository libraryRepository;

    // Constructor Injection for dependency injection
    public LibraryService (LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }
    @Override
    public void addBook(Book book){
        libraryRepository.addBook(book);
    }

    @Override
    public Book findBookById(int id) {
        return libraryRepository.findBookById(id);
    }

    @Override
    public Book removeBook(int bookId){
        return libraryRepository.removeBook(bookId);
    }

    @Override
    public Map<Integer, Book> getAllBooks() {
        return libraryRepository.getAllBooks();
    }
}
