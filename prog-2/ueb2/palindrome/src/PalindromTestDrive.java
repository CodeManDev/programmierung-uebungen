import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class PalindromTestDrive {

    public static void main(String[] args) {
        System.out.println("Running PalindromTestDrive...");

        List<Palindrom> palindroms = List.of(new PalindromRekursiv(), new PalindromIterativ());

        int maxWordLength = 1000;
        long[][] totalTimes = new long[palindroms.size()][maxWordLength];
        long[] times = new long[100];

        for (int p = 0; p < palindroms.size(); p++) {
            Palindrom palindrom = palindroms.get(p);
            System.out.println("Testing " + palindrom + "...");
            for (int i = 1; i <= maxWordLength; i++) {
                for (int j = 0; j < 100; j++) {
                    String palindrome = randomPalindrome(i);

                    long startTime = System.nanoTime();
                    palindrom.istPalindrom(palindrome);
                    long endTime = System.nanoTime();

                    times[j] = endTime - startTime;
                }
                totalTimes[p][i - 1] = average(times);
            }

            // print results
            System.out.println("Results for " + palindrom + ":");
            System.out.println("Word Length\tTime (ns)");
            for (int i = 0; i < maxWordLength; i++) {
                System.out.printf("%d\t\t%d%n", i + 1, totalTimes[p][i]);
            }

            // save results to CSV
//            String fileName = "palindrome_" + palindrom + ".csv";
//            try (PrintWriter writer = new PrintWriter(fileName)) {
//                writer.println("Word Length,Time (ns)");
//                for (int i = 0; i < totalTimes.length; i++) {
//                    writer.printf("%d,%d%n", i + 1, totalTimes[i]);
//                }
//            } catch (IOException e) {
//                System.err.println("Error writing to file: " + e.getMessage());
//            }
        }

        String fileName = "palindrome_results.csv";
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println("Word Length,Recursive Time (ns),Iterative Time (ns)");
            for (int i = 0; i < maxWordLength; i++) {
                writer.printf("%s,%d,%d%n", i + 1, totalTimes[0][i], totalTimes[1][i]);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static String randomPalindrome(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= length / 2; i++) {
            char c = (char) ('a' + Math.random() * 26);
            sb.append(c);
        }

        for (int i = length / 2 - 1; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }

        return sb.toString();
    }

    private static long average(long[] times) {
        if (times.length == 0)
            return 0;

        long sum = 0;
        for (long time : times)
            sum += time;
        return sum / times.length;
    }

    private static long median(long[] times) {
        Arrays.sort(times);
        if (times.length % 2 == 0) {
            return (times[times.length / 2 - 1] + times[times.length / 2]) / 2;
        } else {
            return times[times.length / 2];
        }
    }

}
