public class Main {

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3, 4}, 0, 3);
    }

    public static void permute(int[] arr, int start, int end) {
        if (start == end) {
            printArray(arr); // basis fall
        } else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i); // swap
                permute(arr, start + 1, end); // rekursiver Aufruf
                swap(arr, start, i); // zurück swappen
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
