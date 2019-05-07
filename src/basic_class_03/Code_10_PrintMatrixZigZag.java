package basic_class_03;

public class Code_10_PrintMatrixZigZag {
    public static void PrintMatrixZigZag(int[][] arr) {
        int upCol = 0;
        int upRow = 0;
        int downCol = 0;
        int downRow = 0;
        int endCol = arr[0].length - 1;
        int endRow = arr.length - 1;
        boolean flag = false;
        while (upRow != endRow + 1) {
            printMatrix(arr, upRow, upCol, downRow, downCol, flag);
            flag = !flag;
            upRow = upCol < endCol ? upRow : ++upRow;
            upCol = upCol < endCol ? ++upCol : upCol;
            downCol = downRow < endRow ? downCol : ++downCol;
            downRow = downRow < endRow ? ++downRow : downRow;
        }
        System.out.println();
    }

    public static void printMatrix(int[][] arr, int upRow, int upCol, int downRow, int downCol, boolean flag) {
        if (flag) {
            while (upRow != downRow + 1) {
                System.out.print(arr[upRow++][upCol--] + " ");
            }
        } else {
            while (downRow != upRow - 1) {
                System.out.print(arr[downRow--][downCol++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        PrintMatrixZigZag(matrix);
    }
}
