import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BookManager {
    private final List<String> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(String book) {
        if (book == null || book.isBlank())
            throw new IllegalArgumentException("Book title must not be null or empty");
        this.books.add(book);
    }

    public void removeBook(String book) {
        if (!this.books.contains(book))
            throw new NoSuchElementException("Book with title \"%s\" not found in library".formatted(book));
        this.books.remove(book);
    }

    public void printBooks() {
        System.out.println("Books in the library:");
        for (String book : this.books) {
            System.out.println(" - " + book);
        }
    }

}
