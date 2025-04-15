import java.util.NoSuchElementException;

public class BookManagerTestDrive {

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.addBook("Java von Kopf bis Fuß");
        manager.addBook("Effective Java");
        manager.printBooks();

        System.out.println();
        System.out.println("Attempting to remove book that doesnt exist:");
        try {
            manager.removeBook("Harry Potter");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        manager.printBooks();

        System.out.println();
        System.out.println("Attempting to add book with empty title:");
        try {
            manager.addBook("");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
