package leetcode.medium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class HIndexTest {

    private HIndex hIndex;

    private static Stream<Arguments> getArgumentsCitation() {
        return Stream.of(
                Arguments.of(new int[]{44, 10, 25, 0, 25, 49, 0}, 5),
                Arguments.of(new int[]{3, 0, 6, 1, 5}, 3),
                Arguments.of(new int[]{22, 5, 25, 15, 28, 1}, 5),
                Arguments.of(new int[]{1, 3, 3, 2}, 2));
    }

    @BeforeEach
    void setUp() {
        hIndex = new HIndex();
    }

    @AfterEach
    void tearDown() {
        hIndex = null;
    }

    @Order(1)
    @DisplayName("Тест: H-index of citations. BinarySearch.")
    @MethodSource("getArgumentsCitation")
    @ParameterizedTest(name = "H-index for {0} = {1} ")
    void hIndex(int[] citations, int expected) {
        Assertions.assertEquals(expected, hIndex.hIndex(citations));
    }

    @Order(2)
    @DisplayName("Тест: H-index of citations. Sorting array.")
    @MethodSource("getArgumentsCitation")
    @ParameterizedTest(name = "H-index for {0} = {1} ")
    void hIndexSorting(int[] citations, int expected) {
        Assertions.assertEquals(expected, hIndex.hIndex(citations));
    }
}