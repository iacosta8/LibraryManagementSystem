public class Book {
    private int ID;
    private String title;
    private String author;
    private boolean availability;

    public Book(int ID, String title, String author) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.availability = true; // Initially, all books are available.
    }

    // Getters and Setters
    public int getID() { return ID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return availability; }

    public void borrowBook() {
        this.availability = false;
    }

    public void returnBook() {
        this.availability = true;
    }
}
