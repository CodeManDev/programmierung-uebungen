import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class IntegerConsumer {

    // K: cross sum, V: list of timestamps for this cross sum
    private final HashMap<Integer, ArrayList<Long>> crossSums;

    public IntegerConsumer() {
        this.crossSums = new HashMap<>();
    }

    public void consume(int number) {
        int crossSum = calculateCrossSum(number);
        long timestamp = System.currentTimeMillis();

        this.crossSums.computeIfAbsent(crossSum, (c) -> new ArrayList<>()).add(timestamp);
    }

    private int calculateCrossSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public int numberOfDifferentResults() {
        return this.crossSums.size();
    }

    public int numberOfOccurrences(int crossSum) {
        if (!this.crossSums.containsKey(crossSum))
            return 0;
        return this.crossSums.get(crossSum).size();
    }

    public List<Integer> getCrossTotalsAscending() {
        List<Integer> sortedCrossSums = new ArrayList<>(this.crossSums.keySet());
        sortedCrossSums.sort(Comparator.naturalOrder());
        return sortedCrossSums;
    }

    public List<Integer> getCrossTotalsDescending() {
        List<Integer> sortedCrossSums = new ArrayList<>(this.crossSums.keySet());
        sortedCrossSums.sort(Comparator.reverseOrder());
        return sortedCrossSums;
    }

    public List<Long> getTimestampsForResult(int crossSum) {
        if (!this.crossSums.containsKey(crossSum))
            return null;
        return this.crossSums.get(crossSum);
    }

}
