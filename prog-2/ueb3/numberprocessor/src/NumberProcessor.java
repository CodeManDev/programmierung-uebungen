public class NumberProcessor {

    private final int[] values;

    public NumberProcessor(int[] values) {
        this.values = values.clone();
    }

    public void printGreaterThan(int threshold) {

        class Filter {
            private final int threshold;

            public Filter(int threshold) {
                this.threshold = threshold;
            }

            public boolean matchesFilter(int value) {
                return value > this.threshold;
            }
        }

        Filter filter = new Filter(threshold);

        for (int value : this.values) {
            if (!filter.matchesFilter(value)) continue;
            System.out.println(value);
        }
    }

}
