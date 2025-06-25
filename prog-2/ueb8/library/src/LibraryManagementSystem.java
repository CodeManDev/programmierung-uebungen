import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LibraryManagementSystem {

    private final TreeSet<Book> books;
    private final HashMap<String, User> users;
    private final PriorityQueue<Book> borrowedBooks;

    public LibraryManagementSystem() {
        this.books = new TreeSet<>(Comparator.comparing(Book::getTitle));
        this.users = new HashMap<>();
        this.borrowedBooks = new PriorityQueue<>(Comparator.comparing(Book::getReturnDate));
    }

    public Book getBook(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public User getUser(String readerId) {
        return users.get(readerId);
    }

    public void addUser(User user) {
        users.put(user.getReaderId(), user);
    }

    public List<Book> getAllBooks() {
        return books.stream().toList();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean borrowBook(User user, Book book) {
        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
            return false;
        }

        LocalDate returnDate = LocalDate.now().plusWeeks(2);
        user.borrowBook(book, returnDate);
        borrowedBooks.add(book);

        return true;
    }

    public boolean returnBook(User user, Book book) {
        if (!book.isBorrowed()) {
            System.out.println("Book is not borrowed.");
            return false;
        }

        user.returnBook(book);
        borrowedBooks.remove(book);
        return true;
    }

    public List<Book> getBorrowedBooksByUser(User user) {
        return new ArrayList<>(user.getBorrowedBooks());
    }

    public List<Book> getAllBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    public List<Book> getBooksAfterYear(int year) {
        return books.stream()
                .filter(book -> book.getYear() > year)
                .toList();
    }

    public List<Book> getBooksSortedByPages() {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getPages))
                .toList();
    }

    public int getTotalPages() {
        return books.stream()
                .mapToInt(Book::getPages)
                .sum();
    }

    public List<Book> getBooksByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .toList();
    }

    public double getAverageRatingForGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .mapToDouble(Book::getRating)
                .average()
                .orElse(0.0);
    }

    public List<Book> getTop3Books() {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getRating).reversed())
                .limit(3)
                .toList();
    }

    public List<String> getAuthorsWithMostBooks() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey).toList();
    }

    public List<Book> getBooksSortedByRating() {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getRating).reversed())
                .toList();
    }

    public List<Book> filterAndSortBooks(Predicate<Book> filter, Comparator<Book> sorter) {
        return books.stream()
                .filter(filter)
                .sorted(sorter)
                .collect(Collectors.toList());
    }

}
