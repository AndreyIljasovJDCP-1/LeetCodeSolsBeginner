package leetcode.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/description/">
 *     74. Search a 2D Matrix</a>
 */
public class MatrixBinarySearch74 {
    public static void main(String[] args) {
        System.out.println(
            searchMatrix(new int[][]{
                {1,3,5,7,8},
                {10,11,16,20,25,36,37,38,40,41},
                {42,43,45},
                {76},
                {80,100,120,140,160},
                {200,250,300,350,351,352,373},
                {1000,3000,3400,6000}}, 1));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearch(matrix, target);
        if (row < 0) return false;
        return binarySearch(matrix, target, row) == 1;
    }

    private static int binarySearch(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int middle = -1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            System.out.println(left + " left " + right + " right");
            System.out.println(middle + " middle");
            if (target > matrix[middle][matrix[middle].length - 1]) {
                left = middle + 1;
            } else if (target < matrix[middle][0]) {
                right = middle - 1;
            } else {
                System.out.println(Arrays.toString(matrix[middle]) + " matrix[middle] row = " + middle);
                return middle;
            }
        }
        return -1;
    }

    private static int binarySearch(int[][] matrix, int target, int row) {
        int left = 0;
        int right = matrix[row].length - 1;
        int middle = -1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            System.out.println(left + " left " + right + " right");
            System.out.println(middle + " middle");
            if (target > matrix[row][middle]) {
                left = middle + 1;
            } else if (target < matrix[row][middle]) {
                right = middle - 1;
            } else {
                System.out.println(matrix[row][middle] + " = matrix[row][middle]");
                return 1;
            }
        }
        return -1;
    }
}
