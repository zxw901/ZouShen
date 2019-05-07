package basic_class_01;

import java.util.Arrays;

public class Code_06_InvertedArray {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);     //防止溢出
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            if (arr[p1] > arr[p2]) {
                for (int j = p1; j <= m; j++)
                    System.out.print(arr[j] + "&" + arr[p2] + " ");
            }
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        System.arraycopy(help, 0, arr, l, help.length);     //注意 arr的起始位置是L不是0
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
//            arr[i] = (int) (Math.random() * (maxValue + 1) - Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[i] > arr[j + 1]) {
                    System.out.print(arr[i] + "&" + arr[j + 1] + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
//        int testSize = 10;
//        int testValue = 100;
//        int[] arr = generateRandomArray(testSize, testValue);
        int[] arr = {100, 23, 51, 72, 63};
        System.out.println(Arrays.toString(arr));
        comparator(arr);
        System.out.println();
        mergeSort(arr);
        System.out.println();
    }
}
