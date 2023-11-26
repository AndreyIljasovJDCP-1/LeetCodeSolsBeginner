package leetcode.medium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {
    private Sudoku sudoku;
    private static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'5','3','.','.','7','.','.','.','2'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','1','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}}, true));
    }

    @BeforeEach
    void setUp() {
        sudoku = new Sudoku();
    }

    @AfterEach
    void tearDown() {
        sudoku = null;
    }

    @Order(1)
    @DisplayName("Тест: Sudoku has valid data.")
    @MethodSource("getArguments")
    @ParameterizedTest(name = "Sudoku is valid expected: {1}")
    void isValidSudoku(char[][] board, boolean expected) {
        assertTrue(sudoku.isValidSudoku(board));
    }
}