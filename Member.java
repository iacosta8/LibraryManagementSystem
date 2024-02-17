// Team: Night Owls (Isaac Acosta, Cayden Haas, Eddie Brito)
// CSCI 428 - Homework 2 - Library Management System
// Date: 02/12/2024

import java.util.ArrayList;
import java.util.List;

public class Member {
    protected int ID;
    protected String name;
    protected List<Book> borrowedBooks = new ArrayList<>();

    public Member(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public void register() {
        // Registration logic
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook(); // Update the book's availability
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        // Check if the book is in the borrowedBooks list before returning
        if (borrowedBooks.contains(book)) {
            book.returnBook(); // Update the book's availability
            borrowedBooks.remove(book);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("You haven't borrowed this book.");
        }
    }
}