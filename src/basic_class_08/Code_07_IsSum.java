package basic_class_08;

public class Code_07_IsSum {
    public static boolean isSum(int[] arr, int i, int sum, int num) {
        if (i == arr.length - 1) {
            return sum == num;
        }
        return isSum(arr, i + 1, sum, num) || isSum(arr, i + 1, sum + arr[i], num);
    }
}
