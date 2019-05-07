package basic_class_02;

public class Code_06_MaxGap {
    public static int MaxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            maxValue = Math.max(arr[i], maxValue);
            minValue = Math.min(arr[i], minValue);
        }
        if (minValue == maxValue) {
            return 0;
        }
        boolean[] hasNum = new boolean[size + 1];
        int[] maxNum = new int[size + 1];
        int[] minNum = new int[size + 1];
        int buNum = 0;
        for (int i = 0; i < size; i++) {
            buNum = bucket(arr[i], size, minValue, maxValue);
            maxNum[buNum] = hasNum[buNum] ? Math.max(maxNum[buNum], arr[i]) : arr[i];
            minNum[buNum] = hasNum[buNum] ? Math.min(minNum[buNum], arr[i]) : arr[i];
            hasNum[buNum] = true;
        }
        int res = 0;
        int lastMax = maxNum[0];
        for (int i = 1; i <= size; i++) {
            if (hasNum[i]) {
                res = Math.max(res, minNum[i] - lastMax);
                lastMax = maxNum[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long size, long min, long max) {
        return (int) ((num - min) * size / (max - min));
    }

    public static void main(String[] angs) {
        int[] arr = {30, 8, 45, 6, 20};
        int gap = MaxGap(arr);
        System.out.println(gap);
    }
}
