package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/valid-sudoku/description/">36. Valid Sudoku</a>
 */
public class Sudoku {

    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            Set<Character> setRows = new HashSet<>();
            Set<Character> setColumns = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char row = board[i][j];
                char column = board[j][i];
                int key = i - i % 3 + j / 3;
                if (row != '.' && !map.computeIfAbsent(key, v -> new HashSet<>()).add(row)) return false;
                if (row != '.' && !setRows.add(row) || column != '.' && !setColumns.add(column)) return false;
            }
        }
        return true;
    }

    public boolean isValidSudokuArray(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') {
                    continue;
                }
                int x = Character.getNumericValue(c);
                int box = (row / 3) * 3 + (col / 3);
                // Check if number has been found in row, col or box
                if (rows[row][x - 1] || cols[col][x - 1] || boxes[box][x - 1]) {
                    return false;
                }
                rows[row][x - 1] = true;
                cols[col][x - 1] = true;
                boxes[box][x - 1] = true;
            }
        }
        return true;
    }
}
