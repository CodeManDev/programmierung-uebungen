import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        HashSet<Eruption> eruptions = new HashSet<>();

        try (var lines = CsvLineReader.readCsvSkippingHeader("volcanos.csv")) {
            lines.forEach(line -> {
                Eruption eruption = EruptionCsvParser.parseLine(line);
                eruptions.add(eruption);
            });
        } catch (Exception e) {
            System.err.println("Fehler beim Lesen der CSV-Datei: " + e.getMessage());
        }

        System.out.println("Anzahl der Eruptionen: " + eruptions.size());

        System.out.println("Durchschnittliche Dauer der Eruptionen in Tagen: " +
                eruptions.stream()
                        .mapToInt(Eruption::duration)
                        .average()
                        .orElse(0.0));

        System.out.println("Letzte bekannte Eruptionen für alle Vulkan:");
        LinkedList<Eruption> latestEruptions = new LinkedList<>();
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getVolcanoNumber))
                .forEach((volcanoNumber, eruptionList) -> eruptionList.stream()
                        .max(Comparator.comparingInt(Eruption::getStartYear)
                                .thenComparingInt(Eruption::getStartMonth)
                                .thenComparingInt(Eruption::getStartDay))
                        .ifPresent(latestEruptions::add));
        latestEruptions.forEach(System.out::println);

        System.out.println("Alle Eruptionen vor dem jahr 1000:");
        eruptions.stream()
                .filter(e -> e.getStartYear() < 1000)
                .forEach(System.out::println);

        System.out.println("Top 10 Jahre mit den meisten Eruptionen:");
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getStartYear, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())).limit(10)
                .forEach(entry -> System.out.println("Jahr: " + entry.getKey() + ", Eruptionen: " + entry.getValue()));

        System.out.println("Kategorisierung der Ausbrüche nach Evidence Method:");
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getEvidenceMethod, Collectors.counting()))
                .forEach((method, count) -> System.out.println("Evidence Method: " + method + ", Anzahl: " + count));

        System.out.println("Anzahl der Eruptionen nördlich des Äquators: " +
                eruptions.stream()
                        .filter(e -> e.getLatitude() > 0)
                        .count());

        System.out.println("Anzahl der Eruptionen südlich des Äquators: " +
                eruptions.stream()
                        .filter(e -> e.getLatitude() < 0)
                        .count());

        System.out.println("Anzahl der Eruptionen je Dekade:");
        eruptions.stream()
                .collect(Collectors.groupingBy(e -> e.getStartYear() / 10 * 10, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .forEach(entry -> System.out.println("Dekade: " + entry.getKey() + ", Eruptionen: " + entry.getValue()));

        System.out.println("Anzahl der Eruptionen je Vulkan:");
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getVolcanoName, Collectors.counting()))
                .forEach((volcanoName, count) -> System.out.println("Vulkan: " + volcanoName + ", Eruptionen: " + count));

        System.out.println("Eruptionen mit start und end Datum im selben Jahr:");
        eruptions.stream()
                .filter(e -> e.getStartYear() == e.getEndYear())
                .forEach(System.out::println);

        System.out.println("Verteilung der Eruptionsdauer:");
        eruptions.stream()
                .collect(Collectors.groupingBy(e -> {
                    int duration = e.duration();
                    if (duration <= 1) return "0-1";
                    else if (duration <= 5) return "2-5";
                    else if (duration <= 10) return "6-10";
                    else return "10+";
                }, Collectors.counting()))
                .forEach((category, count) -> System.out.println("Kategorie: " + category + ", Anzahl: " + count));

        System.out.println("Längste bekannte Eruption:");
        eruptions.stream()
                .max(Comparator.comparingInt(Eruption::duration))
                .ifPresent(longestEruption -> System.out.println("Eruption: " + longestEruption +
                        ", Dauer: " + longestEruption.duration() + " Tage"));

        System.out.println("Evidence Method sortiert nach Häufigkeit:");
        eruptions.stream()
                .collect(Collectors.groupingBy(Eruption::getEvidenceMethod, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println("Evidence Method: " + entry.getKey() + ", Anzahl: " + entry.getValue()));

        System.out.println("10 Vulkane mit den kürzesten bekannten Eruptionen:");
        eruptions.stream()
                .sorted(Comparator.comparingInt(Eruption::duration))
                .limit(10)
                .forEach(System.out::println);
    }
}