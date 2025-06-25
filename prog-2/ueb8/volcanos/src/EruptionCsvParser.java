import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Die Klasse {@code EruptionCsvParser} enthält Methoden zur Umwandlung
 * von CSV-Zeilen in Eruption-Objekte.
 * 
 * Erwartet wird ein CSV-Datensatz mit Semikolontrennung.
 * Leere Felder werden als 0 bzw. 0.0 interpretiert.
 */
public class EruptionCsvParser {

    /**
     * Wandelt eine einzelne CSV-Zeile in ein {@link Eruption}-Objekt um.
     *
     * @param line eine Zeile aus der CSV-Datei, Felder durch Semikolon getrennt
     * @return ein Eruption-Objekt, das die Daten der Zeile repräsentiert
     */
    public static Eruption parseLine(String line) {
        String[] parts = line.split(";", -1); // -1 = auch leere Felder behalten

        int volcanoNumber = parseInt(parts[0]);
        String volcanoName = parts[1].trim();
        int eruptionNumber = parseInt(parts[2]);
        int startYear = parseInt(parts[8]);
        int startMonth = parseInt(parts[10]);
        int startDay = parseInt(parts[12]);
        String evidenceMethod = parts[14].trim();
        int endYear = parseInt(parts[16]);
        int endMonth = parseInt(parts[18]);
        int endDay = parseInt(parts[20]);
        double latitude = parseDouble(parts[22]);
        double longitude = parseDouble(parts[23]);

        return new Eruption(volcanoNumber, volcanoName, eruptionNumber,
                startYear, startMonth, startDay,
                evidenceMethod, endYear, endMonth, endDay,
                latitude, longitude);
    }

    /**
     * Versucht, einen {@code String} in einen {@code int} zu konvertieren.
     * Bei Fehlern wird {@code 0} zurückgegeben.
     *
     * @param value die zu parsende Zeichenkette
     * @return ganzzahliger Wert oder 0 bei Fehler
     */
    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Versucht, einen {@code String} in einen {@code double} zu konvertieren.
     * Bei Fehlern wird {@code 0.0} zurückgegeben.
     *
     * @param value die zu parsende Zeichenkette
     * @return Gleitkommazahl oder 0.0 bei Fehler
     */
    private static double parseDouble(String value) {
        try {
            return Double.parseDouble(value.trim());
        } catch (Exception e) {
            return 0.0;
        }
    }
}
