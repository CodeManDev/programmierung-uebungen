import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        System.out.println("x^2 (squares)");
        applyAndPrint(0, 9, i -> i * i);

        System.out.println("x! (factorial)");
        applyAndPrint(0, 9, i -> {
            int total = 1;
            for (int j = 2; j <= i; j++) {
                total *= j;
            }
            return total;
        });

        System.out.println("x^(x+1)");
        applyAndPrint(0, 9, i -> (int) Math.pow(i, i+1));


        ConditionalFunction fibonacci = (i) -> {
            if (i < 2) return i;
            int a = 0, b = 1;
            for (int j = 2; j <= i; j++) {
                int next = a + b;
                a = b;
                b = next;
            }
            return b;
        };

        System.out.println("Fibonacci numbers:");
        applyAndPrint(1, 9, fibonacci);

        Predicate<Integer> odd = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 != 0;
            }
        };
        Predicate<Integer> even = i -> i % 2 == 0;

        ConditionalFunction squared = i -> i * i;

        System.out.println("Quadrate von geraden Zahlen:");
        applyAndPrint(0, 9, squared.conditionateInput(even));

        System.out.println("Ungerade Fibonacci Zahlen:");
        applyAndPrint(1, 9, fibonacci.conditionateOutput(odd));


    }

    public static void applyAndPrint(int i, int j, Function<Integer, Integer> f) {
        for (int k = i; k <= j; k++) {
            System.out.println(f.apply(k));
        }
    }

    public static class Factorial implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer n) {
            int total = 1;
            for (int j = 2; j <= n; j++) {
                total *= j;
            }
            return total;
        }
    }
}