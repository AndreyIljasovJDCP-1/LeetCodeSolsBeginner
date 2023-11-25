package leetcode.medium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GasStationTest {
    private GasStation gasStation;

    private static Stream<Arguments> getArgumentsGasStation() {
        return Stream.of(
                Arguments.of(new int[]{1, 6, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 1),
                Arguments.of(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}, 4),
                Arguments.of(new int[]{3, 1, 1}, new int[]{1, 2, 2}, 0),
                Arguments.of(new int[]{5, 5, 1, 3, 4}, new int[]{8, 1, 7, 1, 1}, 3),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 5, 70}, new int[]{2, 3, 4, 3, 9, 6, 2}, 6),
                Arguments.of(new int[]{2, 5, 1, 4, 3}, new int[]{3, 2, 2, 2, 6}, 1));
    }

    @BeforeEach
    void setUp() {
        gasStation = new GasStation();
    }

    @AfterEach
    void tearDown() {
        gasStation = null;
    }

    @Order(1)
    @DisplayName("Тест: Start Index of circle trip of GasStation.")
    @MethodSource("getArgumentsGasStation")
    @ParameterizedTest(name = "Index for gas{0} and cost{1} = {2} ")
    void canCompleteCircuit(int[] gas, int[] cost, int expected) {
        Assertions.assertEquals(expected,gasStation.canCompleteCircuit(gas,cost));
    }
}