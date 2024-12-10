package stringarraylist.test;

import stringarraylist.main.StringArrayList;

import java.util.Arrays;

public class StringArrayListTestDrive {

    public static void main(String[] args) {
        System.out.println("ArrayList<String> Wrapper Test");

        StringArrayList stringArrayList = new StringArrayList();

        stringArrayList.add("eins");
        stringArrayList.add("zwei");
        stringArrayList.add("drei");
        stringArrayList.add("vier");
        stringArrayList.add("fünf");

        stringArrayList.print();

        stringArrayList.add("sechs");

        stringArrayList.print();

        stringArrayList.remove(2);
        stringArrayList.print();

        stringArrayList.set(2, "acht");
        stringArrayList.print();

        System.out.println("contains(\"sechs\"): " + stringArrayList.contains("sechs"));

        System.out.println("contains(\"sieben\"): " + stringArrayList.contains("sieben"));

        System.out.println("isEmpty(): " + stringArrayList.isEmpty());

        System.out.println("toArray(): " + Arrays.toString(stringArrayList.toArray()));

        System.out.println("length(): " + stringArrayList.length());

        System.out.println("clear()");
        stringArrayList.clear();

        System.out.println("isEmpty(): " + stringArrayList.isEmpty());

        stringArrayList.print();
    }

}
