package basic_class_03;

public class Code_07_RotatePrintMatrix {
    public static void RotateMatrix(int[][] arr) {
        if (arr == null) {
            return;
        }
        int leftRow = 0;
        int leftCol = 0;
        int rightRow = arr.length - 1;
        int rightCol = arr[0].length - 1;
        while (leftRow <= rightRow && leftCol <= rightCol) {
            PrintfMatrix(arr, leftRow++, leftCol++, rightRow--, rightCol--);
        }
    }

    public static void PrintfMatrix(int[][] arr, int leftRow, int leftCol, int rightRow, int rightCol) {
        if (leftRow == rightRow) {
            while (leftCol <= rightCol)
                System.out.print(arr[leftRow][leftCol++] + " ");
            return;
        }
        if (leftCol == rightCol) {
            while (leftRow <= rightRow) {
                System.out.print(arr[leftRow++][leftCol] + " ");
            }
            return;
        }
        int curR = leftRow;
        int curC = leftCol;
        while (curC != rightCol) {
            System.out.print(arr[leftRow][curC++] + " ");
        }
        while (curR != rightRow) {
            System.out.print(arr[curR++][rightRow] + " ");
        }
        while (curC != leftCol) {
            System.out.print(arr[rightRow][curC--] + " ");
        }
        while (curR != leftRow) {
            System.out.print(arr[curR--][leftCol] + " ");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        RotateMatrix(matrix);
    }
}
