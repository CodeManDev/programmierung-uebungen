package stringarray;

public class StringArrayTestDrive {
    public static void main(String[] args) {
        System.out.println("String[] Wrapper Test");

        StringArray stringArray = new StringArray(5);

        stringArray.add("eins");
        stringArray.add("zwei");
        stringArray.add("drei");
        stringArray.add("vier");
        stringArray.add("fünf");

        stringArray.print();

        stringArray.add("sechs");

        stringArray.print();

        stringArray.remove(2);
        stringArray.print();

        stringArray.set(2, "acht");
        stringArray.print();

        System.out.println("index 3: " + stringArray.get(3));
    }
}