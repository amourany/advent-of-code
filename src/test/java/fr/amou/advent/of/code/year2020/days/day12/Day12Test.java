package fr.amou.advent.of.code.year2020.days.day12;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day12Test {

    @Test
    void part1_example1() {
        // Given
        List<String> instructions = List.of("F10", "N3", "F7", "R90", "F11");

        // When
        Ship ship = Day12.followEvasivePath(instructions, new Part1RuleSet());
        Integer manhattanDistance = Day12.computeManhattanDistance(ship);

        // Then
        Assertions.assertThat(manhattanDistance)
                .isEqualTo(25);
    }

    @Test
    void part2_example1() {
        // Given
        List<String> instructions = List.of("F10", "N3", "F7", "R90", "F11");

        // When
        Ship ship = Day12.followEvasivePath(instructions, new Part2RuleSet());
        Integer manhattanDistance = Day12.computeManhattanDistance(ship);

        // Then
        Assertions.assertThat(manhattanDistance)
                .isEqualTo(286);
    }
}