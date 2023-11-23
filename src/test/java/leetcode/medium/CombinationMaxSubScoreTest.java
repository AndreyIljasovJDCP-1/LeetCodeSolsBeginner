package leetcode.medium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Тест класса CombinationMaxSubScore.")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CombinationMaxSubScoreTest {
    private CombinationMaxSubScore maxSubScore;

    private static Stream<Arguments> getArgumentsSum() {
        return Stream.of(Arguments.of(
                        new int[]{44, 10, 25, 0, 25, 49, 0},
                        new int[]{18, 39, 15, 31, 43, 20, 45}, 6, 2304),
                Arguments.of(new int[]{2, 1, 14, 12},
                        new int[]{11, 7, 13, 6}, 3, 168),
                Arguments.of(new int[]{22, 5, 25, 15, 28, 1},
                        new int[]{22, 30, 25, 25, 9, 18}, 3, 1364),
                Arguments.of(new int[]{1, 3, 3, 2},
                        new int[]{2, 1, 3, 4}, 3, 12));
    }

    @BeforeEach
    void setUp() {
        maxSubScore = new CombinationMaxSubScore();
    }

    @AfterEach
    void tearDown() {
        maxSubScore = null;
    }

    @Order(1)
    @DisplayName("Тест: Max sum of K-long subs.")
    @MethodSource("getArgumentsSum")
    @ParameterizedTest(name = "Max score = sum * min of {2}-long subs for {0} and {1} = {3} ")
    void maxScoreMatrixQueuePairs(int[] nums1, int[] nums2, int k, long expected) {
        long actual = maxSubScore.maxScoreMatrixQueuePairs(nums1, nums2, k);
        Assertions.assertEquals(expected, actual);
    }
}