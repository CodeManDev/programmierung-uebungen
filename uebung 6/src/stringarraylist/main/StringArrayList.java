package stringarraylist.main;

public class StringArrayList {

    private final java.util.ArrayList<String> arrayList;

    public StringArrayList() {
        this.arrayList = new java.util.ArrayList<>();
    }

    public void add(String value) {
        this.arrayList.add(value);
    }

    public String get(int index) {
        return this.arrayList.get(index);
    }

    public void set(int index, String value) {
        this.arrayList.set(index, value);
    }

    public void remove(int index) {
        this.arrayList.remove(index);
    }

    public int length() {
        return this.arrayList.size();
    }

    public boolean contains(String value) {
        return this.arrayList.contains(value);
    }

    public void clear() {
        this.arrayList.clear();
    }

    public String[] toArray() {
        return this.arrayList.toArray(new String[0]);
    }

    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    public void print() {
        for (String string : this.arrayList) {
            System.out.print(string);
            System.out.print(", ");
        }
        System.out.println();
        System.out.println("length: " + this.length());
    }

}
