package basic_class_01;

public class Code_05_SmallSum {
    public static int mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);     //防止溢出
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        System.arraycopy(help, 0, arr, l, help.length);     //注意 arr的起始位置是L不是0
        return res;
    }

    public static void swap(int[] arr, int i, int j) {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
        arr[i] = arr[i] ^ arr[j];       //数组同一位置交换时不能使用 如：swap(arr,0,0);
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
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

    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[i] > arr[j - 1]) {
                    res += arr[j - 1];
                }
            }
        }
        return res;
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
            int res1 = comparator(array2);
            int res2 = mergeSort(array3);
            if (res1 != res2) {
                System.out.println("false");
                System.out.println("通过率为：" + ((double) times / (double) testTimes * 100) + "%");
                System.out.println("数组：");
                printArray(array1);
                System.out.println("正确答案是：" + res1);
                System.out.println("你的答案是：" + res2);
                return;
            }
            times++;
        }
        System.out.println("true");
    }
}
