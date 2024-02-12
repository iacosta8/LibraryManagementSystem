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
        book.returnBook(); // Update the book's availability
        borrowedBooks.remove(book);
    }
}
