package fr.amou.advent.of.code.year2020.days;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day5Test {

    @Test
    @DisplayName("Should compute a seatID of 567 for the partitioner BFFFBBFRRR")
    void part1_example1() {
        // Given
        String partitioner = "BFFFBBFRRR";

        // When
        Integer seatId = Day5.computeSeatId(partitioner);

        // Then
        assertThat(seatId).isEqualTo(567);
    }

    @Test
    @DisplayName("Should compute a seatID of 119 for the partitioner FFFBBBFRRR")
    void part1_example2() {
        // Given
        String partitioner = "FFFBBBFRRR";

        // When
        Integer seatId = Day5.computeSeatId(partitioner);

        // Then
        assertThat(seatId).isEqualTo(119);
    }

    @Test
    @DisplayName("Should compute a seatID of 820 for the partitioner BBFFBBFRLL")
    void part1_example3() {
        // Given
        String partitioner = "BBFFBBFRLL";

        // When
        Integer seatId = Day5.computeSeatId(partitioner);

        // Then
        assertThat(seatId).isEqualTo(820);
    }
}