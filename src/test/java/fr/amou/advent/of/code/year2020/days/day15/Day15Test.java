package fr.amou.advent.of.code.year2020.days.day15;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class Day15Test {

    @Test
    void part1_example1() {
        // Given
        List<Integer> startingNumbers = List.of(0, 3, 6);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 2020);
        Integer result = Day15.findValueForRound(2020, results);

        // Then
        assertThat(result).isEqualTo(436);
    }

    @Test
    void part1_example2() {
        // Given
        List<Integer> startingNumbers = List.of(1, 3, 2);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 2020);
        Integer result = Day15.findValueForRound(2020, results);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void part1_example3() {
        // Given
        List<Integer> startingNumbers = List.of(2, 1, 3);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 2020);
        Integer result = Day15.findValueForRound(2020, results);

        // Then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void part1_example4() {
        // Given
        List<Integer> startingNumbers = List.of(1, 2, 3);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 2020);
        Integer result = Day15.findValueForRound(2020, results);

        // Then
        assertThat(result).isEqualTo(27);
    }

    @Test
    void part1_example5() {
        // Given
        List<Integer> startingNumbers = List.of(2, 3, 1);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 2020);
        Integer result = Day15.findValueForRound(2020, results);

        // Then
        assertThat(result).isEqualTo(78);
    }

    @Test
    void part1_example6() {
        // Given
        List<Integer> startingNumbers = List.of(3, 2, 1);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 2020);
        Integer result = Day15.findValueForRound(2020, results);

        // Then
        assertThat(result).isEqualTo(438);
    }

    @Test
    void part1_example7() {
        // Given
        List<Integer> startingNumbers = List.of(3, 1, 2);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 2020);
        Integer result = Day15.findValueForRound(2020, results);

        // Then
        assertThat(result).isEqualTo(1836);
    }

    @Test
    void part2_example1() {
        // Given
        List<Integer> startingNumbers = List.of(0, 3, 6);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 30000000);
        Integer result = Day15.findValueForRound(30000000, results);

        // Then
        assertThat(result).isEqualTo(175594);
    }

    @Test
    void part2_example2() {
        // Given
        List<Integer> startingNumbers = List.of(1, 3, 2);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 30000000);
        Integer result = Day15.findValueForRound(30000000, results);

        // Then
        assertThat(result).isEqualTo(2578);
    }

    @Test
    void part2_example3() {
        // Given
        List<Integer> startingNumbers = List.of(2, 1, 3);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 30000000);
        Integer result = Day15.findValueForRound(30000000, results);

        // Then
        assertThat(result).isEqualTo(3544142);
    }

    @Test
    void part2_example4() {
        // Given
        List<Integer> startingNumbers = List.of(1, 2, 3);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 30000000);
        Integer result = Day15.findValueForRound(30000000, results);

        // Then
        assertThat(result).isEqualTo(261214);
    }

    @Test
    void part2_example5() {
        // Given
        List<Integer> startingNumbers = List.of(2, 3, 1);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 30000000);
        Integer result = Day15.findValueForRound(30000000, results);

        // Then
        assertThat(result).isEqualTo(6895259);
    }

    @Test
    void part2_example6() {
        // Given
        List<Integer> startingNumbers = List.of(3, 2, 1);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 30000000);
        Integer result = Day15.findValueForRound(30000000, results);

        // Then
        assertThat(result).isEqualTo(18);
    }

    @Test
    void part2_example7() {
        // Given
        List<Integer> startingNumbers = List.of(3, 1, 2);

        // When
        Map<Integer, Integer[]> results = Day15.playGame(startingNumbers, 30000000);
        Integer result = Day15.findValueForRound(30000000, results);

        // Then
        assertThat(result).isEqualTo(362);
    }
}