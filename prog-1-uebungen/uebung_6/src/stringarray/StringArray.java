package stringarray;

import java.util.*;

public class StringArray {

    private String[] array;
    private int stringsCount;

    public StringArray(int size) {
        this.array = new String[size];
        this.stringsCount = 0;
    }

    public String get(int index) {
        if (index < 0 || index >= this.array.length)
            return null;

        return this.array[index];
    }

    public void set(int index, String value) {
        if (index < 0 || index >= this.array.length)
            return;

        if (this.array[index] == null)
            this.stringsCount++;

        this.array[index] = value;
    }

    public int length() {
        return this.stringsCount;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.array.length)
            return;

        if (this.array[index] != null)
            this.stringsCount--;

        this.array[index] = null;
    }

    public int add(String value) {
        if (this.stringsCount >= this.array.length)
            this.resize();

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == null) {
                this.array[i] = value;
                this.stringsCount++;
                return i;
            }
        }

        return -1;
    }

    public void resize() {
        String[] newArray = new String[this.array.length + this.array.length / 2];

        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }

    public void print() {
        System.out.println(Arrays.toString(this.array));
        System.out.println("length: " + this.length());
    }

}
