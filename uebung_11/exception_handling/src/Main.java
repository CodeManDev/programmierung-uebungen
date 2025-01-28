import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bitte geben Sie ein Datum ein (yyyy-mm-dd): ");
            String dateInput = scanner.nextLine();

            LocalDate localDate = LocalDate.parse(dateInput, DateTimeFormatter.ISO_DATE);
            System.out.println("Datum ist gültig!");
            System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        } catch (DateTimeParseException parseException) {
            System.out.println("Fehler beim Parsen des Datums.");
        }
    }
}