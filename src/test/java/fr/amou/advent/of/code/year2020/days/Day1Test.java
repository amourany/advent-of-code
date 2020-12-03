package fr.amou.advent.of.code.year2020.days;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day1Test {

    @Test
    void day1_part1_example1() {
        // Given
        List<Integer> givenEntries = List.of(1721, 979, 366, 299, 675, 1456);

        // When
        int result = Day1.fixExpenseReport(givenEntries, 2);

        // Then
        Assertions.assertThat(result)
                .isEqualTo(514579);
    }

    @Test
    void day1_part2_example1() {
        // Given
        List<Integer> givenEntries = List.of(1721, 979, 366, 299, 675, 1456);

        // When
        int result = Day1.fixExpenseReport(givenEntries, 3);

        // Then
        Assertions.assertThat(result)
                .isEqualTo(241861950);
    }
}