package loops;

import java.util.Arrays;

public class BreakDemo {

    public static void main(String[] args) {
        System.out.println("Break Demo");

        test(new int[]{10, 20, 30, 40, 50, 60}, 50);

        test(new int[]{5, 15, 25, 35, 45}, 50);

        test(new int[]{60, 70, 80, 90}, 50);

        test(new int[]{}, 50);
    }

    private static void test(int[] numbers, int criteria) {

        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Kriterium: " + criteria);

        if (numbers.length == 0) {
            System.out.println("Array ist leer. Kein Wert überprüfbar.");
            return;
        }

        System.out.println("Überprüfte Werte:");

        boolean found = false;
        for (int number : numbers) {
            System.out.println(number);
            if (number > criteria) {
                System.out.println("Gefundener Wert: " + number);
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Kein Wert erfüllt die Bedingung.");

        System.out.println();
    }

}
