import java.time.LocalDate;
import java.util.Locale;

public class Book {

    private final String title;
    private final String author;
    private final int year;
    private final int pages;
    private final String genre;
    private final double rating; // 1.0 - 5.0
    private boolean borrowed;
    private LocalDate returnDate;

    public Book(String title, String author, int year, int pages, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.genre = genre;
        this.rating = rating < 1.0 ? 1.0 : Math.min(rating, 5.0);
        this.borrowed = false;
        this.returnDate = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", borrowed=" + borrowed +
                ", returnDate=" + returnDate +
                '}';
    }
}
