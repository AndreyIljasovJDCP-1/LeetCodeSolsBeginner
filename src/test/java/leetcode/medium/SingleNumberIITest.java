package leetcode.medium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SingleNumberIITest {
    private SingleNumberII singleNumberII;

    private static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.of(new int[]{44, 44, 25, 44, 0, 0, 0}, 25),
                Arguments.of(new int[]{3, 0, 3, 3}, 0),
                Arguments.of(new int[]{22, 5, 22, 15, 22, 15, 15}, 5),
                Arguments.of(new int[]{43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43}, 2147483647),
                Arguments.of(new int[]{3, 3, 3, 2}, 2));
    }

    @BeforeEach
    void setUp() {
        singleNumberII = new SingleNumberII();
    }

    @AfterEach
    void tearDown() {
        singleNumberII = null;
    }

    @Order(1)
    @DisplayName("Тест: Single number of array.")
    @MethodSource("getArguments")
    @ParameterizedTest(name = "Single number for {0} = {1} ")
    void singleNumber(int[] nums, int expected) {
        Assertions.assertEquals(expected, singleNumberII.singleNumber(nums));
    }
}