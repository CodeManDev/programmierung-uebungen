package loops;

public class WhileLoopDemo {

    public static void main(String[] args) {

        System.out.println("While Loop Demo");

        String[] numbers = {"eins", "zwei", "drei", "vier", "fünf"};

        System.out.println();

        int i = 0;
        while (i < numbers.length) {
            System.out.println(numbers[i]);
            i++;
        }

        System.out.println();

        int j = numbers.length - 1;
        while (j >= 0) {
            System.out.println(numbers[j]);
            j--;
        }

        System.out.println();

    }

}
