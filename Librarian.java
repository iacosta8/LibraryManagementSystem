// Team: Night Owls (Isaac Acosta, Cayden Haas, Eddie Brito)
// CSCI 428 - Homework 2 - Library Management System
// Date: 02/12/2024

public class Librarian extends Member implements Manageable {
    private LibraryCollection collection;

    public Librarian(int ID, String name, LibraryCollection collection) {
        super(ID, name);
        this.collection = collection;
    }

    @Override
    public void addBook(Book book) {
        collection.addBook(book);
    }

    @Override
    public void removeBook(Book book) {
        collection.removeBook(book);
    }
    
    // Method to get the Librarian's collection
    public LibraryCollection getCollection() {
        return this.collection;
    }
}


// testing to see if pushong works properly