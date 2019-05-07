package basic_class_03;

import java.util.Arrays;

public class Code_08_RotateMatrix {
    public static void RotateMatrix(int[][] arr) {
        if (arr == null) {
            return;
        }
        int upRow = 0;
        int upCol = 0;
        int downRow = arr.length - 1;
        int downCol = arr[0].length - 1;
        while (upRow < downRow) {       //方的
            Rotate(arr, upRow++, upCol++, downRow--, downCol--);
        }
    }

    public static void Rotate(int[][] arr, int upRow, int upCol, int downRow, int downCol) {
        int times = downCol - upCol;
        for (int i = 0; i < times; i++) {       //i初值必须为0
            int tmp = arr[upRow + i][upCol];
            arr[upRow + i][upCol] = arr[downRow][upCol + i];
            arr[downRow][upCol + i] = arr[downRow - i][downCol];
            arr[downRow - i][downCol] = arr[upRow][downCol - i];
            arr[upRow][downCol - i] = tmp;
        }
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
//    public static void printMatrix(int[][] matrix) {
//        for (int i = 0; i != matrix.length; i++) {
//            for (int j = 0; j != matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
        printMatrix(array);
        System.out.println("-------------------------------------");
        RotateMatrix(array);
        printMatrix(array);
    }
}
