package basic_class_02;

import java.util.Arrays;

public class Code_04_HeapSort {
    public static void HeapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            HeapInsert(arr, i);         //0~i 已经形成大根堆
        }
        int size = arr.length;
        while (size > 1) {
            swap(arr, 0, --size);
            Heapify(arr, 0, size);
        }
    }

    public static void HeapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void Heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;   //这个三目写的好！！
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
//            if (arr[index] < arr[largest]) {
//                swap(arr, index, largest);
//                index = largest;
//                left = index * 2 + 1;
//            } else {
//                break;
//            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
        int testTimes = 1000;
        int testSize = 1000;
        int testValue = 1000;
        int times = 0;
        for (int i = 0; i < testTimes; i++) {
            int[] array1 = generateRandomArray(testSize, testValue);
            int[] array2 = copyArray(array1);
            int[] array3 = copyArray(array1);
            comparator(array2);
            HeapSort(array3);
            if (!isEqual(array2, array3)) {
                System.out.println("false");
                System.out.println("通过率为：" + ((double) times / (double) testTimes * 100) + "%");
                System.out.println("数组：");
                System.out.println(Arrays.toString(array1));
                System.out.println("正确答案是：");
                System.out.println(Arrays.toString(array2));
                System.out.println("你的答案是：");
                System.out.println(Arrays.toString(array3));
                return;
            }
        }
        System.out.println("true");
    }
}
