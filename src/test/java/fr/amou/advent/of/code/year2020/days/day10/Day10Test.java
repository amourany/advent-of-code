package fr.amou.advent.of.code.year2020.days.day10;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class Day10Test {

    @Test
    void part1_example1() {
        // Given
        List<Integer> input = List.of(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4);

        // When
        Map<Integer, Integer> adapterChainDifferences = Day10.findAdapterChainDifferences(input);

        Integer diffOf1 = adapterChainDifferences.get(1);
        Integer diffOf3 = adapterChainDifferences.get(3);

        // Then
        assertThat(diffOf1).isEqualTo(7);
        assertThat(diffOf3).isEqualTo(5);
    }

    @Test
    void part1_example2() {
        // Given
        List<Integer> input = List.of(28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45, 19, 38, 39, 11, 1, 32, 25,
                35, 8, 17, 7, 9, 4, 2, 34, 10, 3);

        // When
        Map<Integer, Integer> adapterChainDifferences = Day10.findAdapterChainDifferences(input);

        Integer diffOf1 = adapterChainDifferences.get(1);
        Integer diffOf3 = adapterChainDifferences.get(3);

        // Then
        assertThat(diffOf1).isEqualTo(22);
        assertThat(diffOf3).isEqualTo(10);
    }

    @Test
    void part2_example1() {
        // Given
        List<Integer> input = List.of(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4);

        // When
        Double result = Day10.countAllPermutations(input);

        // Then
        assertThat(result).isEqualTo(8);
    }

    @Test
    void part2_example2() {
        // Given
        List<Integer> input = List.of(28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45, 19, 38, 39, 11, 1, 32, 25,
                35, 8, 17, 7, 9, 4, 2, 34, 10, 3);

        // When
        Double result = Day10.countAllPermutations(input);

        // Then
        assertThat(result).isEqualTo(19208);
    }
}