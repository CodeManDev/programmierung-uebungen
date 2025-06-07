import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CrossSumsMain {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java Main <fifo/natural>");
            return;
        }

        String mode = args[0];

        if (!mode.equals("fifo") && !mode.equals("natural")) {
            System.out.println("Invalid mode. Use 'fifo' or 'natural'.");
            return;
        }

        Queue<Integer> numberQueue;

        if (mode.equals("fifo")) numberQueue = new LinkedList<>();
        else numberQueue = new PriorityQueue<>();

        RandomProducer producer = new RandomProducer();
        IntegerConsumer consumer = new IntegerConsumer();

        for (int i = 0; i < 10000; i++) {
            if (Math.random() < 0.5 || numberQueue.isEmpty()) {
                int producedNumber = producer.produce();
                numberQueue.add(producedNumber);
            } else {
                int consumedNumber = numberQueue.poll();
                consumer.consume(consumedNumber);
            }
        }

        System.out.println("Number of different results: " + consumer.numberOfDifferentResults());
        System.out.println("Cross totals in ascending order: " + consumer.getCrossTotalsAscending());
        System.out.println("Cross totals in descending order: " + consumer.getCrossTotalsDescending());
        System.out.println("Occurrences of cross sum 10: " + consumer.numberOfOccurrences(10));
        Collection<Long> timestamps = consumer.getTimestampsForResult(10);
        if (timestamps != null) {
            System.out.println("Timestamps for cross sum 10: " + timestamps);
        } else {
            System.out.println("No timestamps found for cross sum 10.");
        }
        System.out.println("Finished processing.");
    }
}