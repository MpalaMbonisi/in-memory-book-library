package com.github.mpalambonisi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        // create a container that keeps objects
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        LibraryService libraryService = (LibraryService) context.getBean("libraryService");

        Scanner scanner = new Scanner(System.in);
        boolean running = true; // shows application status

        while(running){
            System.out.println("\nWelcome to the Library");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book By ID");
            System.out.println("3. Remove Book");
            System.out.println("4. List All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch(choice){
                case 1 -> {
                    System.out.println("\n-------- Add Book --------\n");
                    System.out.print("Enter Book Id: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Enter Book Genre: ");
                    String bookGenre = scanner.nextLine();
                    System.out.print("Enter year published: ");
                    int yearBookPublished = scanner.nextInt();

                    Book book = new Book(bookId, bookTitle, bookAuthor, bookGenre, yearBookPublished);
                    libraryService.addBook(book);
                    System.out.println("Book added successfully!");
                }

                case 2 -> {
                    System.out.println("\n-------- View Book --------\n");
                    System.out.print("Enter Book Id: ");
                    int bookId = scanner.nextInt();
                    Book book = libraryService.findBookById(bookId);
                    if (book != null) System.out.println("Book successfully found!\n" + book);
                    else{
                        System.out.println("Book not found in the Library!");
                    }
                }

                case 3 -> {
                    System.out.println("\n-------- Remove Book --------\n");
                    System.out.print("Enter Book Id to remove : ");
                    int bookId = scanner.nextInt();
                    Book removedBook = libraryService.removeBook(bookId);
                    if (removedBook != null) System.out.println("Book successfully removed!");
                    else System.out.println("Book not found in the Library!");
                }

                case 4 -> {
                    System.out.println("\n-------- Library --------\n");
                    libraryService.getAllBooks().values().forEach(System.out::println);
                }

                case 5 -> {
                    running = false;
                    System.out.println("Exiting the Library System. \nGoodbye ;)");
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
