import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringProcessor {

    private LinkedList<String> strings;

    public StringProcessor() {
        this.strings = new LinkedList<>();
    }

    public StringProcessor(LinkedList<String> strings) {
        this.strings = strings;
    }

    public void add(String str) {
        this.strings.addLast(str);
    }

    public LinkedList<String> filter(Predicate<String> predicate) {
        return this.strings.filter(predicate);
    }

    public void applyToAll(Function<String, String> function) {
        LinkedList<String> newList = new LinkedList<>();
        for (String str : this.strings)
            newList.addLast(function.apply(str));
        this.strings = newList;
    }

    public LinkedList<Integer> mapToInt(Function<String, Integer> function) {
        LinkedList<Integer> intList = new LinkedList<>();
        for (String str : this.strings)
            intList.addLast(function.apply(str));
        return intList;
    }

    public void forEach(Consumer<String> consumer) {
        for (String str : this.strings)
            consumer.accept(str);
    }
}
