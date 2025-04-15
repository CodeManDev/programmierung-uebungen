import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class ReadDateFromFile {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ReadDateFromFile <file_name>");
            System.out.println("Please provide a file name.");
            return;
        }

        File file = new File(args[0]);

        if (!file.exists()) {
            System.out.printf("Error: File '%s' does not exist.%n", args[0]);
            return;
        }

        String date;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            date = reader.readLine();
            System.out.printf("Success: Date '%s' has been read from file '%s'.%n", date, args[0]);
        } catch (IOException e) {
            System.out.println("Error: Unable to read from file.");
            System.out.printf("Details: %s%n", e.getMessage());

            return;
        }

        try {
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            System.out.printf("Success: Formatted date (%s locale): %s%n", Locale.getDefault().getDisplayLanguage(Locale.ENGLISH), localDate);
        } catch (DateTimeParseException parseException) {
            System.out.printf("Error: Unable to parse date in the file '%s'.%n", args[0]);
            System.out.println("Make sure the date is in the correct format (yyyy-MM-dd).");
            System.out.printf("Details: %s%n", parseException.getMessage());
        }
    }

}
