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
}