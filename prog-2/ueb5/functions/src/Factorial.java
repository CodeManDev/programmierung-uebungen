import java.util.function.Function;

public class Factorial implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer n) {
        int total = 1;
        for (int j = 2; j <= n; j++) {
            total *= j;
        }
        return total;
    }
}
