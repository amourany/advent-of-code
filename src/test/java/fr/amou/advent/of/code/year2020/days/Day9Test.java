package fr.amou.advent.of.code.year2020.days;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class Day9Test {

    @Test
    void part1_example1() {
        // Given
        List<Integer> inputData = List.of(35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299,
                277, 309, 576);

        // When
        Double firstInvalidNumber = Day9.findFirstInvalidNumber(inputData.stream()
                .map(Double::valueOf)
                .collect(Collectors.toList()), 5);

        // Then
        Assertions.assertThat(firstInvalidNumber)
                .isEqualTo(127);
    }
}