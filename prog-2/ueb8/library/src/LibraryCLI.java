
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LibraryCLI {
    private LibraryManagementSystem libraryManagementSystem;
    private Scanner scanner;

    public LibraryCLI(LibraryManagementSystem libraryManagementSystem) {
        this.libraryManagementSystem = libraryManagementSystem;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        loadBooksFromCSV("books.csv");

        boolean running = true;

        while (running) {
            System.out.println("\n--- Bücherverwaltungssystem ---");
            System.out.println("1. Buch hinzufügen");
            System.out.println("2. Alle Bücher anzeigen");
            System.out.println("3. Bücher nach Jahr filtern");
            System.out.println("4. Bücher nach Seitenanzahl sortieren");
            System.out.println("5. Gesamtanzahl der Seiten berechnen");
            System.out.println("6. Buch ausleihen");
            System.out.println("7. Buch zurückgeben");
            System.out.println("8. Ausgeliehene Bücher eines Nutzers anzeigen");
            System.out.println("9. Alle ausgeliehenen Bücher anzeigen, sortiert nach Rückgabedatum");
            System.out.println("10. Bücher nach Genre filtern");
            System.out.println("11. Durchschnittliche Bewertung pro Genre berechnen");
            System.out.println("12. Top-bewertete Bücher anzeigen");
            System.out.println("13. Autoren mit den meisten Büchern anzeigen");
            System.out.println("14. Bücher nach Bewertung sortieren");
            System.out.println("15. Gefilterte und sortierte Liste der Bücher anzeigen");
            System.out.println("16. Programm beenden");
            System.out.print("Bitte wählen Sie eine Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    filterBooksByYear();
                    break;
                case 4:
                    sortBooksByPages();
                    break;
                case 5:
                    calculateTotalPages();
                    break;
                case 6:
                    borrowBook();
                    break;
                case 7:
                    returnBook();
                    break;
                case 8:
                    displayBorrowedBooksByUser();
                    break;
                case 9:
                    displayAllBorrowedBooks();
                    break;
                case 10:
                    filterBooksByGenre();
                    break;
                case 11:
                    calculateAverageRatingPerGenre();
                    break;
                case 12:
                    displayTopRatedBooks();
                    break;
                case 13:
                    displayAuthorsWithMostBooks();
                    break;
                case 14:
                    sortBooksByRating();
                    break;
                case 15:
                    filterAndSortBooks();
                    break;
                case 16:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte versuchen Sie es erneut.");
            }
        }
    }

    private void loadBooksFromCSV(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            reader.lines().skip(1).forEach(line -> {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    int pages = Integer.parseInt(parts[3].trim());
                    String genre = parts[4].trim();
                    double rating = Double.parseDouble(parts[5].trim());

                    Book book = new Book(title, author, year, pages, genre, rating);
                    libraryManagementSystem.addBook(book);
                } else {
                    System.err.println("Ungültige Zeile in der CSV-Datei: " + line);
                }
            });

        } catch (IOException e) {
            System.err.println("Fehler beim Laden der Bücher: " + e.getMessage());
        }
    }

    private void addBook() {
        System.out.print("Titel: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Veröffentlichungsjahr: ");
        int year = scanner.nextInt();
        System.out.print("Anzahl der Seiten: ");
        int pages = scanner.nextInt();
        System.out.print("Genre: ");
        String genre = scanner.next();
        System.out.print("Bewertung: ");
        double rating = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Book book = new Book(title, author, year, pages, genre, rating);
        libraryManagementSystem.addBook(book);
        System.out.println("Buch hinzugefügt!");
    }

    private void displayAllBooks() {
        List<Book> books = libraryManagementSystem.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("Keine Bücher vorhanden.");
        } else {
            System.out.println("Alle Bücher:");
            books.forEach(System.out::println);
        }
    }

    private void filterBooksByYear() {
        System.out.print("Geben Sie das Jahr ein, nach dem gefiltert werden soll: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Book> filteredBooks = libraryManagementSystem.getBooksAfterYear(year);
        if (filteredBooks.isEmpty()) {
            System.out.println("Keine Bücher gefunden, die nach dem Jahr " + year + " veröffentlicht wurden.");
        } else {
            System.out.println("Bücher nach Jahr " + year + ":");
            filteredBooks.forEach(System.out::println);
        }
    }

    private void sortBooksByPages() {
        List<Book> sortedBooks = libraryManagementSystem.getBooksSortedByPages();
        if (sortedBooks.isEmpty()) {
            System.out.println("Keine Bücher vorhanden.");
        } else {
            System.out.println("Bücher nach Seitenanzahl sortiert:");
            sortedBooks.forEach(System.out::println);
        }
    }

    private void calculateTotalPages() {
        int totalPages = libraryManagementSystem.getTotalPages();
        System.out.println("Gesamtanzahl der Seiten in allen Büchern: " + totalPages);
    }

    private void borrowBook() {
        System.out.print("Geben Sie die Leser-ID des Nutzers ein: ");
        String readerId = scanner.nextLine();
        User user = libraryManagementSystem.getUser(readerId);
        if (user == null) {
            System.out.print("Bitte geben Sie den Namen des neuen Nutzers ein: ");
            String userName = scanner.nextLine();
            user = new User(userName, readerId);
            libraryManagementSystem.addUser(user);
        }
        System.out.print("Geben Sie den Titel des auszuleihenden Buches ein: ");
        String bookTitle = scanner.nextLine();
        Book book = libraryManagementSystem.getBook(bookTitle);
        if (book == null) {
            System.out.println("Buch nicht gefunden.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("Das Buch ist bereits ausgeliehen.");
            return;
        }

        if (!libraryManagementSystem.borrowBook(user, book)) {
            System.out.println("Das Buch konnte nicht ausgeliehen werden.");
        } else {
            System.out.println("Buch erfolgreich ausgeliehen. Rückgabedatum: " + book.getReturnDate());
        }
    }

    private void returnBook() {
        System.out.print("Geben Sie die Leser-ID des Nutzers ein: ");
        String readerId = scanner.nextLine();
        User user = libraryManagementSystem.getUser(readerId);
        if (user == null) {
            System.out.println("Nutzer nicht gefunden.");
            return;
        }
        System.out.print("Geben Sie den Titel des zurückzugebenden Buches ein: ");
        String bookTitle = scanner.nextLine();
        Book book = libraryManagementSystem.getBook(bookTitle);
        if (book == null || !book.isBorrowed()) {
            System.out.println("Buch nicht gefunden oder nicht ausgeliehen.");
            return;
        }

        if (!user.getBorrowedBooks().contains(book)) {
            System.out.println("Das Buch wurde nicht von diesem Nutzer ausgeliehen.");
            return;
        }

        if (!libraryManagementSystem.returnBook(user, book)) {
            System.out.println("Das Buch konnte nicht zurückgegeben werden.");
        } else {
            System.out.println("Buch erfolgreich zurückgegeben.");
        }
    }

    private void displayBorrowedBooksByUser() {
        System.out.print("Geben Sie die Leser-ID des Nutzers ein: ");
        String readerId = scanner.nextLine();
        User user = libraryManagementSystem.getUser(readerId);
        if (user == null) {
            System.out.println("Nutzer nicht gefunden.");
            return;
        }

        List<Book> borrowedBooks = libraryManagementSystem.getBorrowedBooksByUser(user);
        if (borrowedBooks.isEmpty()) {
            System.out.println("Keine ausgeliehenen Bücher für diesen Nutzer.");
        } else {
            System.out.println("Ausgeliehene Bücher von " + user.getName() + ":");
            borrowedBooks.forEach(System.out::println);
        }
    }

    private void displayAllBorrowedBooks() {
        List<Book> borrowedBooks = libraryManagementSystem.getAllBorrowedBooks();
        if (borrowedBooks.isEmpty()) {
            System.out.println("Keine ausgeliehenen Bücher vorhanden.");
        } else {
            System.out.println("Alle ausgeliehenen Bücher, sortiert nach Rückgabedatum:");
            borrowedBooks.forEach(System.out::println);
        }
    }

    private void filterBooksByGenre() {
        System.out.print("Geben Sie das Genre ein, nach dem gefiltert werden soll: ");
        String genre = scanner.nextLine();

        List<Book> filteredBooks = libraryManagementSystem.getBooksByGenre(genre);
        if (filteredBooks.isEmpty()) {
            System.out.println("Keine Bücher im Genre '" + genre + "' gefunden.");
        } else {
            System.out.println("Bücher im Genre '" + genre + "':");
            filteredBooks.forEach(System.out::println);
        }
    }

    private void calculateAverageRatingPerGenre() {
        System.out.print("Geben Sie das Genre ein, für das die durchschnittliche Bewertung berechnet werden soll: ");
        String genre = scanner.nextLine();

        double averageRating = libraryManagementSystem.getAverageRatingForGenre(genre);
        if (averageRating <= 0) {
            System.out.println("Keine Bücher im Genre '" + genre + "' gefunden.");
        } else {
            System.out.printf("Durchschnittliche Bewertung für Genre '%s': %.2f%n", genre, averageRating);
        }
    }

    private void displayTopRatedBooks() {
        List<Book> topRatedBooks = libraryManagementSystem.getTop3Books();
        if (topRatedBooks.isEmpty()) {
            System.out.println("Keine Bücher mit Bewertungen vorhanden.");
        } else {
            System.out.println("Top-bewertete Bücher:");
            topRatedBooks.forEach(System.out::println);
        }
    }

    private void displayAuthorsWithMostBooks() {
        List<String> authors = libraryManagementSystem.getAuthorsWithMostBooks();
        if (authors.isEmpty()) {
            System.out.println("Keine Autoren mit Büchern gefunden.");
        } else {
            System.out.println("Autoren mit den meisten Büchern:");
            authors.forEach(System.out::println);
        }
    }

    private void sortBooksByRating() {
        List<Book> sortedBooks = libraryManagementSystem.getBooksSortedByRating();
        if (sortedBooks.isEmpty()) {
            System.out.println("Keine Bücher vorhanden.");
        } else {
            System.out.println("Bücher nach Bewertung sortiert:");
            sortedBooks.forEach(System.out::println);
        }
    }

    private void filterAndSortBooks() {
        System.out.println("Filtern nach benutzerdefinierten Kriterien:");
        System.out.println("1. Nach Jahr");
        System.out.println("2. Nach Seitenanzahl");
        System.out.println("3. Nach Bewertung");
        System.out.print("Wählen Sie ein Filterkriterium: ");
        int filterChoice = scanner.nextInt();
        System.out.print("Wählen Sie 1 für > oder 2 für <: ");
        int comparison = scanner.nextInt();
        System.out.print("Geben Sie den Wert ein: ");
        double filterValue = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Predicate<Book> filter;
        switch (filterChoice) {
            case 1:
                filter = book -> {
                    if (comparison == 1) return book.getYear() > filterValue;
                    else return book.getYear() < filterValue;
                };
                break;
            case 2:
                filter = book -> {
                    if (comparison == 1) return book.getPages() > filterValue;
                    else return book.getPages() < filterValue;
                };
                break;
            case 3:
                filter = book -> {
                    if (comparison == 1) return book.getRating() > filterValue;
                    else return book.getRating() < filterValue;
                };
                break;
            default:
                System.out.println("Ungültige Auswahl.");
                return;
        }

        System.out.println("Sortieren nach benutzerdefinierten Kriterien:");
        System.out.println("1. Nach Titel");
        System.out.println("2. Nach Jahr");
        System.out.println("3. Nach Seitenanzahl");
        System.out.println("4. Nach Bewertung");
        System.out.print("Wählen Sie ein Sortierkriterium: ");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Comparator<Book> sorter;
        switch (sortChoice) {
            case 1:
                sorter = Comparator.comparing(Book::getTitle);
                break;
            case 2:
                sorter = Comparator.comparingInt(Book::getYear);
                break;
            case 3:
                sorter = Comparator.comparingInt(Book::getPages);
                break;
            case 4:
                sorter = Comparator.comparingDouble(Book::getRating);
                break;
            default:
                System.out.println("Ungültige Auswahl.");
                return;
        }

        List<Book> result = libraryManagementSystem.filterAndSortBooks(filter, sorter);
        result.forEach(System.out::println);
    }

    public static void main(String[] args) {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        LibraryCLI libraryCLI = new LibraryCLI(libraryManagementSystem);
        libraryCLI.run();
    }
}
