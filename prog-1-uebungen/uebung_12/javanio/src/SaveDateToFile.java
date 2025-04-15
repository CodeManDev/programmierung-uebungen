import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SaveDateToFile {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java SaveDateToFile <file_name> <date (yyyy-mm-dd)>");
            System.out.println("Please provide a file name and a date.");
            return;
        }

        Path path = Paths.get(args[0]);

        if (Files.exists(path)) {
            System.out.printf("Error: File '%s' already exists.%n", args[0]);
            return;
        }

        try {
            LocalDate localDate = LocalDate.parse(args[1], DateTimeFormatter.ISO_DATE);
            System.out.printf("Success: Date '%s' has been validated.%n", args[1]);
        } catch (DateTimeParseException parseException) {
            System.out.printf("Error: The provided date is '%s' is invalid or not in the correct format (yyyy-MM-dd).%n", args[1]);
            System.out.println("Please provide a valid date in the ISO-8601 format.");
            System.out.printf("Details: %s%n", parseException.getMessage());

            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(args[1]);
            System.out.printf("Success: Date has been written to file '%s'.%n", args[0]);
        } catch (IOException e) {
            System.out.println("Error: Unable to write to file.");
            System.out.printf("Details: %s%n", e.getMessage());
        }
    }
}