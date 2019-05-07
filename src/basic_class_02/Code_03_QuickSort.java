package basic_class_02;

import java.util.Arrays;

public class Code_03_QuickSort {
    public static void QuickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        QuickSort(arr, 0, arr.length - 1);
    }

    public static void QuickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, R, L + (int) (Math.random() * (R - L + 1)));        //不要忘记加 L ！！！！
            int[] p = partition(arr, L, R);
            QuickSort(arr, L, p[0] - 1);
            QuickSort(arr, p[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < arr[R]) {
                swap(arr, cur++, ++less);
            } else if (arr[cur] > arr[R]) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
//            arr[i] = (int) (Math.random() * (maxValue + 1) - Math.random() * (maxValue + 1));
        }
        return arr;
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

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int testTimes = 1000;
        int testSize = 10;
        int testValue = 10;
        int times = 0;
        for (int i = 0; i < testTimes; i++) {
            int[] array1 = generateRandomArray(testSize, testValue);
            int[] array2 = copyArray(array1);
            int[] array3 = copyArray(array1);
            comparator(array2);
            QuickSort(array3);
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
