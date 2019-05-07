package basic_class_05;

public class Code_02_CountIslands {
    public static int countIslands(int[][] arr) {
        int size = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (arr[i][j] == 1) {
                    infect(arr, i, j, arr.length - 1, arr[0].length - 1);
                    size++;
                }
            }
        }
        return size;
    }

    public static void infect(int[][] arr, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || arr[i][j] != 1) {
            return;
        }
        arr[i][j] = 2;
        infect(arr, i + 1, j, N, M);
        infect(arr, i - 1, j, N, M);
        infect(arr, i, j + 1, N, M);
        infect(arr, j, j - 1, N, M);
    }

    public static void main(String[] args) {
        int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m1));

        int[][] m2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m2));
    }
}
