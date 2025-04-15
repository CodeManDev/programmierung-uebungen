import java.util.ArrayList;

public class ListMinMax {

    public static int min(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (Integer integer : list) {
            min = Math.min(min, integer);
        }

        return min;
    }

    public static int max(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        for (Integer integer : list) {
            max = Math.max(max, integer);
        }

        return max;
    }
}
