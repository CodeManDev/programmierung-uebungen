import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        System.out.println("naive approach:");
        boolean[] naivePrimes = createTestArray(10000);
        long naiveStart = System.nanoTime();
        naiveApproach(naivePrimes);
        long naiveEnd = System.nanoTime();

        System.out.println("Primes:");
        printPrimeArray(naivePrimes);
        System.out.println("Naive implementation took " + (naiveEnd - naiveStart) + "ns");

        System.out.println("optimized version:");
        boolean[] optimizedPrimes = createTestArray(10000);
        long optimizedStart = System.nanoTime();
        optimizedApproach(optimizedPrimes);
        long optimizedEnd = System.nanoTime();

        System.out.println("Primes:");
        printPrimeArray(optimizedPrimes);
        System.out.println("Optimized implementation took " + (optimizedEnd - optimizedStart) + "ns");
    }

    private static void naiveApproach(boolean[] primes) {
        for (int i = 2; i < primes.length; i++) {
            for (int j = i * i; j < primes.length; j += i) {
                primes[j] = false;
            }
        }
    }

    private static void optimizedApproach(boolean[] primes) {
        int sqrt = (int) Math.sqrt(primes.length);
        for (int i = 2; i <= sqrt; i++) {
            if (primes[i]) {
                for (int j = i * i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    private static boolean[] createTestArray(int n) {
        boolean[] testArray = new boolean[n + 1];
        Arrays.fill(testArray, true);

        return testArray;
    }

    private static void printPrimeArray(boolean[] primes) {
        for (int i = 1; i < primes.length; i++) {
            if (primes[i])
                System.out.print(i + ", ");
        }
        System.out.println();
    }
}