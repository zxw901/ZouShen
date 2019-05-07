package basic_class_08;

public class Code_06_Walk {
    public static int walk(int[][] arr, int i, int j) {
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            return arr[i][j];
        }
        if (i == arr.length - 1) {
            return arr[i][j] + walk(arr, i, j + 1);
        }
        if (j == arr[0].length - 1) {
            return arr[i][j] + walk(arr, i + 1, j);
        }
        int right = arr[i][j] + walk(arr, i, j + 1);
        int down = arr[i][j] + walk(arr, i + 1, j);
        return Math.min(right, down);
    }
}
