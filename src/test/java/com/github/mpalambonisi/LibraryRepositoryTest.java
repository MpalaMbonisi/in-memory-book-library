package com.github.mpalambonisi;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class LibraryRepositoryTest extends TestCase {
    private LibraryRepository libraryRepository;

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        // Load Spring XML configuration and get the LibraryRepository bean
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        libraryRepository = (LibraryRepository) context.getBean("libraryRepository");
    }

    public void testFindBookById() {
        Book book = new Book(0, "Atomic Habits", "James Clear", "Productivity", 2018);
        libraryRepository.addBook(book);
        Book bookFound = libraryRepository.findBookById(0);
        assertSame(book, bookFound);
    }

    public  void testAddBook() {
        Book book = new Book(0, "Atomic Habits", "James Clear", "Productivity", 2018);
        libraryRepository.addBook(book);
        Book bookFound = libraryRepository.findBookById(0);
        assertSame(book, bookFound);
    }
    public  void testAddBookWithInvalidId() {
        Book book = new Book(0, "Atomic Habits", "James Clear", "Productivity", 2018);
        libraryRepository.addBook(book);
        Book bookFound = libraryRepository.findBookById(1111);
        assertNull(bookFound);
    }

    public void testRemove() {
        Book book = new Book(0, "Atomic Habits", "James Clear", "Productivity", 2018);
        libraryRepository.addBook(book);
        assertSame(book, libraryRepository.removeBook(0));
        assertTrue(libraryRepository.isLibraryEmpty());
    }

    public void testGetAllBooks() {
        Map<Integer, Book> bookStorage =  new HashMap<>();

        // creating book objects for the database
        Book book01 = new Book(0, "Atomic Habits", "James Clear", "Productivity", 2018);
        Book book02 = new Book(1, "Can't Hurt Me", "David Goggins", "Biography", 2018);
        Book book03 = new Book(2, "Harry Potter", "J.K Rowling", "Fiction", 1997);

        // add books to hashMap
        bookStorage.put(0, book01);
        bookStorage.put(1, book02);
        bookStorage.put(2, book03);

        // add all books to the Library Repo
        libraryRepository.addBook(book01);
        libraryRepository.addBook(book02);
        libraryRepository.addBook(book03);

        // test
        assertEquals(bookStorage, libraryRepository.getAllBooks());
    }
}