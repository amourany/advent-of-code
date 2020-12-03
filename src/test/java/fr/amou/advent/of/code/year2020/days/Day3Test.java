package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.common.Coordinate;
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
        List<Coordinate> pathsToFollow = List.of(new Coordinate(3, 1));

        // When
        Long countedTrees = Day3.followSlope(mapLines, pathsToFollow);

        // Then
        assertThat(countedTrees).isEqualTo(7);
    }

    @Test
    @DisplayName("Should produce the answer of 336 for the example2")
    void part1_example2() {
        // Given
        List<String> mapLines = List.of("..##.......", "#...#...#..", ".#....#..#.", "..#.#...#.#", ".#...##..#.",
                "..#.##.....", ".#.#.#....#", ".#........#", "#.##...#...", "#...##....#", ".#..#...#.#");
        List<Coordinate> pathsToFollow = List.of(new Coordinate(1, 1), new Coordinate(3, 1), new Coordinate(5, 1),
                new Coordinate(7, 1), new Coordinate(1, 2));

        // When
        Long countedTrees = Day3.followSlope(mapLines, pathsToFollow);

        // Then
        assertThat(countedTrees).isEqualTo(336);
    }
}