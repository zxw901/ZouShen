package basic_class_01;

import java.util.Arrays;

public class Code_03_InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null)
            return null;
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        return tmp;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr2 == null && arr1 != null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
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

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
//            arr[i] = (int) (Math.random() * (maxValue + 1) - Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int times = 0;
        int testTimes = 5000;
        int testSize = 100;
        int testValue = 1000;
        for (int i = 0; i < testTimes; i++) {
            int[] array1 = generateRandomArray(testSize, testValue);
            int[] array2 = copyArray(array1);
            int[] array3 = copyArray(array1);
            insertionSort(array2);
            comparator(array3);
            if (!isEqual(array2, array3)) {
                System.out.println("false");
                System.out.println("通过率为：" + ((double) times / (double) testTimes * 100) + "%");
                System.out.println("数组：");
                printArray(array1);
                System.out.println("正确答案是：");
                printArray(array2);
                System.out.println("你的答案是：");
                printArray(array3);
                return;
            }
        }
        System.out.println("true");
//        int[] array = {1, 2, 3, 4, 5, 6, 7};
//        bublbeSort(array);
    }
}
