package loops;

public class IncrementDemo {

    public static void main(String[] args) {
        System.out.println("Increment Demo");

        firstExample();
        secondExample();
    }

    private static void firstExample() {

        System.out.println("First Example");

        for (int i = -3; i <= 3; i++) {
            System.out.println(i);
        }

        System.out.println();

        int i = -3;
        while (i <= 3) {
            System.out.println(i);
            i++;
        }

        System.out.println();
    }

    private static void secondExample() {

        System.out.println("Second Example");

        for (int i = 0; i >= -5; i--) {
            System.out.println(i);
        }

        System.out.println();

        int i = 0;
        while (i >= -5) {
            System.out.println(i);
            i--;
        }

        System.out.println();
    }

}
