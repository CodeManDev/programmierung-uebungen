public class Main {
    public static void main(String[] args) {

        StringProcessor processor = new StringProcessor();
        processor.add("Hello");
        processor.add("World");
        processor.add("Java");
        processor.add("Programming");
        processor.add("test");
        processor.add("    12test   ");
        processor.add("\"StringProcessor\"");

        System.out.println("Original Strings:");
        processor.forEach(System.out::println);

        System.out.println();

        System.out.println("Filtered Strings (length > 5):");
        LinkedList<String> filtered = processor.filter(s -> s.length() > 5);
        filtered.forEach(System.out::println);

        System.out.println();

        System.out.println("Filtered Strings (started mit Großbuchstaben):");
        LinkedList<String> filteredCapitalized = processor.filter(s -> Character.isUpperCase(s.charAt(0)));
        filteredCapitalized.forEach(System.out::println);

        System.out.println();

        System.out.println("Führende und nachgestellte Leerzeichen entfernt:");
        processor.applyToAll(String::trim);
        processor.forEach(System.out::println);

        System.out.println();

        System.out.println("Strings in Großbuchstaben:");
        processor.applyToAll(String::toUpperCase);
        processor.forEach(System.out::println);

        System.out.println();

        System.out.println("Umgekehrte Strings:");
        processor.applyToAll(s -> new StringBuilder(s).reverse().toString());
        processor.forEach(System.out::println);

        System.out.println();

        System.out.println("Längen der Strings:");
        LinkedList<Integer> lengths = processor.mapToInt(String::length);
        lengths.forEach(System.out::println);

        System.out.println();

        System.out.println("Wie oft kommt 'a' vor:");
        LinkedList<Integer> aCounts = processor.mapToInt(s -> {
            int count = 0;
            for (char c : s.toCharArray())
                if (c == 'a')
                    count++;
            return count;
        });
        aCounts.forEach(System.out::println);

        System.out.println();

        System.out.println("Strings die mit '\"' beginnen:");
        LinkedList<String> startsWithQuote = processor.filter(s -> s.startsWith("\""));
        startsWithQuote.forEach(System.out::println);

        System.out.println();

        System.out.println("Strings mit ihrer Länge in Klammern:");
        processor.applyToAll(s -> s + " (" + s.length() + ")");
        processor.forEach(System.out::println);

        System.out.println();
    }
}