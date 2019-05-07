package basic_class_02;

import java.util.Arrays;

public class Code_01_ArrayClassify {
    public static void ArrayClassify(int[] arr, int numb) {
        int p = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= numb) {
                swap(arr, i, ++p);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 12, 3, 4, 5, 10, 5};
        ArrayClassify(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}
