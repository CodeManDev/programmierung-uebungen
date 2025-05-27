import java.util.function.Function;
import java.util.function.Predicate;

public interface ConditionalFunction extends Function<Integer, Integer> {

    default Function<Integer, Integer> conditionateInput(Predicate<Integer> predicate) {
        return input -> predicate.test(input) ? apply(input) : 0;
    }

    default Function<Integer, Integer> conditionateOutput(Predicate<Integer> predicate) {
        return input -> {
            Integer result = apply(input);
            return predicate.test(result) ? result : 0;
        };
    }

}
