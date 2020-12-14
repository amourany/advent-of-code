package fr.amou.advent.of.code.year2020.days.day14;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class Day14Test {

    @Test
    void part1_example1() {
        // Given
        List<String> instructionList = List.of(
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X\nmem[8] = 11\nmem[7] = 101\nmem[8] = 0");

        // When
        Map<Integer, String> memory = Day14.applyInstructions(instructionList);
        Long result = Day14.sumAllMemoryValues(memory);

        // Then
        Assertions.assertThat(result)
                .isEqualTo(165);
    }
}