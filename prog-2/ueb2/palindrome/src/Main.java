import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        if (args.length == 0) {
            System.out.println("Bitte geben Sie einen String ein.");
            return;
        }

        String input = args[0];

        if (input.equalsIgnoreCase("--file")) {
            if (args.length < 2) {
                System.out.println("Bitte geben Sie einen Dateinamen ein.");
                return;
            }
            String filename = args[1];
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                input = br.readLine();
            } catch (IOException e) {
                System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
            }
        }

        Palindrom palindromRek = new PalindromRekursiv();
        System.out.println("Rekursiv: " + palindromRek.istPalindrom(input));
        Palindrom palindromIter = new PalindromIterativ();
        System.out.println("Iterativ: " + palindromIter.istPalindrom(input));

    }
}