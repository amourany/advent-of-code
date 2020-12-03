package fr.amou.advent.of.code.days;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day3Test {

    @Test
    @DisplayName("Should count 7 trees for the example1")
    void part1_example1() {
        // Given
        List<String> mapLines = List.of("..##.......", "#...#...#..", ".#....#..#.", "..#.#...#.#", ".#...##..#.",
                "..#.##.....", ".#.#.#....#", ".#........#", "#.##...#...", "#...##....#", ".#..#...#.#");

        // When
        Integer countedTrees = Day3.followSlopeCountingTree(mapLines);

        // Then
        assertThat(countedTrees).isEqualTo(7);
    }
}