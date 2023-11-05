package leetcode.medium;

import java.util.*;

/**
 * @link <a href="https://leetcode.com/problems/equal-row-and-column-pairs/?envType=study-plan-v2&envId=leetcode-75">
 *     2352. Equal Row and Column Pairs</a>
 *
 */
public class MatrixEqualRowColPairs {

    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{
                {3, 3, 3, 6, 18, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3},
                {1, 1, 1, 11, 19, 1, 1, 1, 1, 1},
                {3, 3, 3, 18, 19, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3},
                {3, 3, 3, 1, 6, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3}
        }));
    }

    public int equalPairsHash(int[][] grid) {
        int base = 100003;
        int mod = 1000000007;
        Map<Integer, Integer> counts = new HashMap<>();
        int len = grid.length;
        for (int i = 0; i < grid.length; i++) {
            int hash = 0;
            for (int j = 0; j < len; j++) hash = (hash * base + grid[i][j]) % mod;
            int c = counts.getOrDefault(hash, 0) + 1;
            counts.put(hash, c);
        }
        int ans = 0;
        for ( int i = 0; i < len; i++ ) {
            int hash = 0;
            for ( int j = 0; j < len; j++ ) hash = ( hash * base + grid[j][i] ) % mod;
            int c = counts.getOrDefault(hash, 0);
            ans += c;
        }
        return ans;
    }
    public static int equalPairs(int[][] grid) {
        int pairs = 0;
        int[][] transposed = new int[grid.length][grid.length];
        for (int j = 0; j < grid.length; j++) {
            for (int i = 0; i < grid.length; i++) {
                transposed[i][j] = grid[j][i];
            }
        }
        for (int[] rows : grid) {
            for (int[] cols : transposed) {
                if (Arrays.equals(rows, cols)) pairs++;
            }
        }
        return pairs;
    }
}
