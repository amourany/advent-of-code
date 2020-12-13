package fr.amou.advent.of.code.year2020.days.day13;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day13Test {

    @Test
    void part1_example1() {
        // Given
        Integer currentTimestamp = 939;
        List<Integer> busTimeTable = List.of(7, 13, 59, 31, 19);

        // When
        Integer earliestDeparture = Day13.findEarliestDeparture(busTimeTable, currentTimestamp);

        // Then
        assertThat(earliestDeparture).isEqualTo(295);
    }

    @Test
    void part2_example1() {
        // Given
        List<Integer> busTimeTable = List.of(7, 13, 1, 1, 59, 1, 31, 19);

        // When
        Long earliestTimestamp = Day13.chineseRemainderTheorem(busTimeTable);

        // Then
        assertThat(earliestTimestamp).isEqualTo(1068781);
    }

    @Test
    void part2_example2() {
        // Given
        List<Integer> busTimeTable = List.of(17, 1, 13, 19);

        // When
        Long earliestTimestamp = Day13.chineseRemainderTheorem(busTimeTable);

        // Then
        assertThat(earliestTimestamp).isEqualTo(3417);
    }

    @Test
    void part2_example3() {
        // Given
        List<Integer> busTimeTable = List.of(67, 7, 59, 61);

        // When
        Long earliestTimestamp = Day13.chineseRemainderTheorem(busTimeTable);

        // Then
        assertThat(earliestTimestamp).isEqualTo(754018);
    }

    @Test
    void part2_example4() {
        // Given
        List<Integer> busTimeTable = List.of(67, 1, 7, 59, 61);

        // When
        Long earliestTimestamp = Day13.chineseRemainderTheorem(busTimeTable);

        // Then
        assertThat(earliestTimestamp).isEqualTo(779210);
    }

    @Test
    void part2_example5() {
        // Given
        List<Integer> busTimeTable = List.of(67, 7, 1, 59, 61);

        // When
        Long earliestTimestamp = Day13.chineseRemainderTheorem(busTimeTable);

        // Then
        assertThat(earliestTimestamp).isEqualTo(1261476);
    }

    @Test
    void part2_example6() {
        // Given
        List<Integer> busTimeTable = List.of(1789, 37, 47, 1889);

        // When
        Long earliestTimestamp = Day13.chineseRemainderTheorem(busTimeTable);

        // Then
        assertThat(earliestTimestamp).isEqualTo(1202161486);
    }
}