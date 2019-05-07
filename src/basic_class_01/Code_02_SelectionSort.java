package basic_class_01;

import java.util.Arrays;

public class Code_02_SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
//                if (arr[minIndex] > arr[j]) {
//                    minIndex = j;
//                }
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
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

    public static int[] copyArray(int[] arr1) {
        if (arr1 == null) {
            return null;
        }
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        return arr2;
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

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
//        arr[i] = arr[i] ^ arr[j];     //数组同一位置交换时不能使用 如：swap(arr,0,0);
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];

    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int times = 0;
        int testTimes = 1000;
        int testSize = 5;
        int testValue = 100;
        for (int i = 0; i < testTimes; i++) {
            int[] array1 = generateRandomArray(testSize, testValue);
            int[] array2 = copyArray(array1);
            int[] array3 = copyArray(array1);
            comparator(array2);
            selectionSort(array3);
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
//        int[] arr = {74, 2, 18, 87};
//        selectionSort(arr);
//        printArray(arr);
    }

}
