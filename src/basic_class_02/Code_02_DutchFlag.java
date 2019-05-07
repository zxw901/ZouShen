package basic_class_02;

import java.util.Arrays;

public class Code_02_DutchFlag {
    public static void DuchFlag(int[] arr, int numb) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int pl = -1;
        int pr = arr.length;
        int cur = 0;
        while (cur < pr) {
            if (arr[cur] < numb) {
                swap(arr, cur++, ++pl);
            } else if (arr[cur] > numb) {
                swap(arr, cur, --pr);
            } else {
                cur++;
            }
        }
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

    public static void main(String[] angs) {
        int testSize = 20;
        int testValue = 10;
        int[] arr = generateRandomArray(testSize, testValue);
        DuchFlag(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}
