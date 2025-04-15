import java.util.ArrayList;
import java.util.List;

public class ListMinMaxTestDrive {
    public static void main(String[] args) {
        final ArrayList<Integer> nullList = null;

        final ArrayList<Integer> emptyList = new ArrayList<>(List.of());

         final ArrayList<Integer> singleElement = new ArrayList<>(List.of(1058));

         final ArrayList<Integer> twoElements = new ArrayList<>(List.of(-11, 74));

         final ArrayList<Integer> list = new ArrayList<>(List.of(-91, -64, 20, 90, -54, -95, -81, 0, 79));

         assertEquals(Integer.MAX_VALUE, ListMinMax.min(nullList));
         assertEquals(Integer.MAX_VALUE, ListMinMax.min(emptyList));
         assertEquals(1058, ListMinMax.min(singleElement));
         assertEquals(-11, ListMinMax.min(twoElements));
         assertEquals(-95, ListMinMax.min(list));

         assertEquals(Integer.MIN_VALUE, ListMinMax.max(nullList));
         assertEquals(Integer.MIN_VALUE, ListMinMax.max(emptyList));
         assertEquals(1058, ListMinMax.max(singleElement));
         assertEquals(74, ListMinMax.max(twoElements));
         assertEquals(90, ListMinMax.max(list));
    }

    public static void assertEquals(int expected, int actual) {
        if (expected == actual) {
            System.out.println("[PASS] Expected: " + expected + " - Actual: " + actual);
        } else {
            System.out.println("[FAIL] Expected: " + expected + " - Actual: " + actual);
        }
    }
}