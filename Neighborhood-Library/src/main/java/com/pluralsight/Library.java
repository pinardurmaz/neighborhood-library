package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadBooks();
        homeScreen();
    }

    private static void loadBooks() {
        books.add(new Book(1, "978-1", "Java Basics"));
        books.add(new Book(2, "978-2", "Learn to Code"));
        books.add(new Book(3, "978-3", "OOP Principles"));

        for (int i = 4; i <= 20; i++) {
            books.add(new Book(i, "978-" + i, "Book " + i));
        }
    }

    private static void homeScreen() {
        while (true) {
            System.out.println("\n--- Neighborhood Library ---");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1": showAvailableBooks(); break;
                case "2": showCheckedOutBooks(); break;
                case "3": System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s%n", book.getId(), book.getIsbn(), book.getTitle());
            }
        }
        System.out.print("Enter book ID to check out or X to return: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("X")) return;

        try {
            int id = Integer.parseInt(input);
            Book book = findBookById(id);
            if (book != null && !book.isCheckedOut()) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                book.checkOut(name);
                System.out.println("Book checked out successfully!");
            } else {
                System.out.println("Book is not available.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private static void showCheckedOutBooks() {
        System.out.println("\nChecked Out Books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s | Checked out to: %s%n",
                        book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
            }
        }

        System.out.print("Enter C to check in a book or X to return: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("X")) return;

        if (input.equalsIgnoreCase("C")) {
            System.out.print("Enter book ID to check in: ");
            String idInput = scanner.nextLine();
            try {
                int id = Integer.parseInt(idInput);
                Book book = findBookById(id);
                if (book != null && book.isCheckedOut()) {
                    book.checkIn();
                    System.out.println("Book checked in successfully!");
                } else {
                    System.out.println("Book is not currently checked out.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID.");
            }
        }
    }

    private static Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }
}