// Team: Night Owls (Isaac Acosta, Cayden Haas, Eddie Brito)
// CSCI 428 - Homework 2 - Library Management System
// Date: 02/12/2024

import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class LibrarySystem {
    private static LibraryCollection collection = new LibraryCollection(); // Single instance for the application

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                chooseRole(scanner); // Use the same collection instance across roles
            }
        }
    }

    private static void chooseRole(Scanner scanner) {
        System.out.println("\nSelect role: 1: Librarian, 2: Member, 3: Exit");
        int role = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (role) {
            case 1:
                setupLibrarian(scanner);
                break;
            case 2:
                setupMember(scanner);
                break;
            case 3:
                System.out.println("Exiting System...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid role selected. Please try again.");
        }
    }

    private static void setupLibrarian(Scanner scanner) {
        System.out.println("Enter Librarian ID:");
        int librarianId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.println("Enter Librarian Name:");
        String librarianName = scanner.nextLine();
        Librarian librarian = new Librarian(librarianId, librarianName, collection);
        manageLibrarianActions(scanner, librarian);
    }

    private static void setupMember(Scanner scanner) {
        System.out.println("Enter Member ID:");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.println("Enter Member Name:");
        String memberName = scanner.nextLine();
        Member member = new Member(memberId, memberName);
        manageMemberActions(scanner, member);
    }

    private static void manageLibrarianActions(Scanner scanner, Librarian librarian) {
        boolean running = true;
        while (running) {
            System.out.println("Librarian Actions: 1: Add book, 2: Remove book, 3: Return to role selection, 4: Exit");
            int action = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (action) {
                case 1:
                    addBook(scanner, librarian);
                    break;
                case 2:
                    removeBook(scanner, librarian);
                    break;
                case 3:
                    running = false;
                    System.out.println("Returning to role selection...");
                    break;
                case 4:
                    System.out.println("Exiting System...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid action.");
            }
        }
    }

    private static void manageMemberActions(Scanner scanner, Member member) {
        boolean running = true;
        while (running) {
            System.out.println("Member Actions: 1: Borrow book, 2: Return book, 3: Return to role selection, 4: Exit");
            int action = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (action) {
                case 1:
                    borrowBook(scanner, member);
                    break;
                case 2:
                    returnBook(scanner, member);
                    break;
                case 3:
                    running = false;
                    System.out.println("Returning to role selection...");
                    break;
                case 4:
                    System.out.println("Exiting System...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid action.");
            }
        }
    }

    private static void addBook(Scanner scanner, Librarian librarian) {
        System.out.println("Enter the author's name:");
        String author = scanner.nextLine();
        System.out.println("Enter the book title:");
        String title = scanner.nextLine();
        Book newBook = new Book(collection.getBooks().size() + 1, title, author);
        librarian.addBook(newBook);
        System.out.println("Book added: ID: " + newBook.getID() + ", Title: " + newBook.getTitle() + ", Author: " + newBook.getAuthor());
    }

    private static void removeBook(Scanner scanner, Librarian librarian) {
        System.out.println("Enter book ID to remove:");
        int bookId = scanner.nextInt();
        Book bookToRemove = collection.findBookByID(bookId);
        if (bookToRemove != null) {
            librarian.removeBook(bookToRemove);
            System.out.println("Book removed: " + bookToRemove.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void borrowBook(Scanner scanner, Member member) {
        System.out.println("Enter book ID to borrow:");
        int bookId = scanner.nextInt();
        Book bookToBorrow = collection.findBookByID(bookId);
        if (bookToBorrow != null && bookToBorrow.isAvailable()) {
            member.borrowBook(bookToBorrow);
            System.out.println("Book borrowed: " + bookToBorrow.getTitle());
        } else {
            System.out.println("Book is not available or does not exist.");
        }
    }

   
    private static void returnBook(Scanner scanner, Member member) {
        System.out.println("Enter book ID to return:");
        int bookId = scanner.nextInt();
        Book bookToReturn = collection.findBookByID(bookId);
        if (bookToReturn != null) {
            member.returnBook(bookToReturn);
            //System.out.println("Book returned: " + bookToReturn.getTitle());
        } else {
            System.out.println("Book does not exist.");
        }
    }
}

