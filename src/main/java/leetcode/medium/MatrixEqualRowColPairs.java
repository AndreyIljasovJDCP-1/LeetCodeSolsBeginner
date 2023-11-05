package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @link <a href="https://leetcode.com/problems/equal-row-and-column-pairs/?envType=study-plan-v2&envId=leetcode-75">
 *     2352. Equal Row and Column Pairs</a>
 *
 */
public class MatrixEqualRowColPairs {

    public static void main(String[] args) {
        equalPairs(new int[][]{
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        });
    }

    public static int equalPairs(int[][] grid) {

        List<String> rows = new ArrayList<>();
        List<String> cols = new ArrayList<>();
        String row;
        String col;
        for (int i = 0; i < grid.length; i++) {
            row = "";
            col = "";
            for (int j = 0; j < grid.length; j++) {
                col += grid[j][i];
                row += grid[i][j];
            }
            rows.add(row);
            cols.add(col);
        }

        return cols.size();
    }
}
