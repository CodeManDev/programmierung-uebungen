import java.util.Arrays;

public class NumberProcessorTest {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int[] values = {1, 2, 3, 4, 5, 12, 60};

        System.out.println("Array: " + Arrays.toString(values));

        NumberProcessor numberProcessor = new NumberProcessor(values);

        System.out.println("Numbers greater than 2:");
        numberProcessor.printGreaterThan(2);

        System.out.println("Numbers greater than 5:");
        numberProcessor.printGreaterThan(5);
    }
}