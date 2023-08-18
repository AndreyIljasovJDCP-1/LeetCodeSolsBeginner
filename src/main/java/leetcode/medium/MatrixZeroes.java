package leetcode.medium;

import java.util.Arrays;

public class MatrixZeroes {

    public static void main(String[] args) {
        setZeroes(new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        });
    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean row;
        boolean[] cols = new boolean[m];

        for (int[] rows : matrix) {
            row = false;
            for (int j = 0; j < m; j++) {
                if (rows[j] == 0) {
                    row = true;
                    cols[j] = true;
                }
            }
            if (row) Arrays.fill(rows, 0);
        }
        for (int i = 0; i < cols.length; i++) {
            if (cols[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] lines : matrix) {
            for (int el : lines) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
