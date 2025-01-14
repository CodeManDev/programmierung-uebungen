package loops;

public class ForLoopDemo {

    public static void main(String[] args) {

        System.out.println("For Loop Demo");

        String[] numbers = {"eins", "zwei", "drei", "vier", "fünf"};

        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        System.out.println();

        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }

        System.out.println();

    }

}
