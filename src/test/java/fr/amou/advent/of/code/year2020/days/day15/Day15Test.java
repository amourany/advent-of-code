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
        Map<Integer, Integer> startingRounds = Day15.playStartingRounds(startingNumbers);
        Map<Integer, Integer> results = Day15.playNextRound(startingRounds.size() + 1, 2020, startingRounds);

        // Then
        assertThat(results.get(2020)).isEqualTo(436);
    }

    @Test
    void part1_example2() {
        // Given
        List<Integer> startingNumbers = List.of(1, 3, 2);

        // When
        Map<Integer, Integer> startingRounds = Day15.playStartingRounds(startingNumbers);
        Map<Integer, Integer> results = Day15.playNextRound(startingRounds.size() + 1, 2020, startingRounds);

        // Then
        assertThat(results.get(2020)).isEqualTo(1);
    }

    @Test
    void part1_example3() {
        // Given
        List<Integer> startingNumbers = List.of(2, 1, 3);

        // When
        Map<Integer, Integer> startingRounds = Day15.playStartingRounds(startingNumbers);
        Map<Integer, Integer> results = Day15.playNextRound(startingRounds.size() + 1, 2020, startingRounds);

        // Then
        assertThat(results.get(2020)).isEqualTo(10);
    }

    @Test
    void part1_example4() {
        // Given
        List<Integer> startingNumbers = List.of(1, 2, 3);

        // When
        Map<Integer, Integer> startingRounds = Day15.playStartingRounds(startingNumbers);
        Map<Integer, Integer> results = Day15.playNextRound(startingRounds.size() + 1, 2020, startingRounds);

        // Then
        assertThat(results.get(2020)).isEqualTo(27);
    }

    @Test
    void part1_example5() {
        // Given
        List<Integer> startingNumbers = List.of(2, 3, 1);

        // When
        Map<Integer, Integer> startingRounds = Day15.playStartingRounds(startingNumbers);
        Map<Integer, Integer> results = Day15.playNextRound(startingRounds.size() + 1, 2020, startingRounds);

        // Then
        assertThat(results.get(2020)).isEqualTo(78);
    }

    @Test
    void part1_example6() {
        // Given
        List<Integer> startingNumbers = List.of(3, 2, 1);

        // When
        Map<Integer, Integer> startingRounds = Day15.playStartingRounds(startingNumbers);
        Map<Integer, Integer> results = Day15.playNextRound(startingRounds.size() + 1, 2020, startingRounds);

        // Then
        assertThat(results.get(2020)).isEqualTo(438);
    }

    @Test
    void part1_example7() {
        // Given
        List<Integer> startingNumbers = List.of(3, 1, 2);

        // When
        Map<Integer, Integer> startingRounds = Day15.playStartingRounds(startingNumbers);
        Map<Integer, Integer> results = Day15.playNextRound(startingRounds.size() + 1, 2020, startingRounds);

        // Then
        assertThat(results.get(2020)).isEqualTo(1836);
    }
}