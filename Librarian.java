


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
}
