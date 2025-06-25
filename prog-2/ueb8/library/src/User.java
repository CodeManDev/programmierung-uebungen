import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class User {

    private final String name;
    private final String readerId;
    private Set<Book> borrowedBooks;

    public User(String name, String readerId) {
        this.name = name;
        this.readerId = readerId;

        // sortiert nach Rückgabedatum
        this.borrowedBooks = new TreeSet<>(Comparator.comparing(Book::getReturnDate));
    }

    public String getName() {
        return name;
    }

    public String getReaderId() {
        return readerId;
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book, LocalDate returnDate) {
        book.setBorrowed(true);
        book.setReturnDate(returnDate);
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setBorrowed(false);
            book.setReturnDate(null);
        }
    }
}
