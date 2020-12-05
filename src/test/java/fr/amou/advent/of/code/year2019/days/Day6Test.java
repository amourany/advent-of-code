package fr.amou.advent.of.code.year2019.days;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day6Test {

    @Test
    void part1_example1() {
        // Given
        List<String> mapEntries = List.of("COM)B");
        // When
        Integer orbits = Day6.countOrbits(mapEntries);

        // Then
        assertThat(orbits).isEqualTo(1);
    }

    @Test
    void part1_example2() {
        // Given
        List<String> mapEntries = List.of("COM)B", "B)G", "G)H");
        // When
        Integer orbits = Day6.countOrbits(mapEntries);

        // Then
        assertThat(orbits).isEqualTo(6);
    }

    @Test
    void part1_example3() {
        // Given
        List<String> mapEntries = List.of("B)G", "COM)B", "G)H");
        // When
        Integer orbits = Day6.countOrbits(mapEntries);

        // Then
        assertThat(orbits).isEqualTo(6);
    }

    @Test
    void part2_example1() {
        // Given
        List<String> mapEntries = List.of("C)D", "J)K", "E)J", "D)E", "D)I", "K)YOU", "I)SAN");
        // When
        Integer orbits = Day6.countJumps(mapEntries);

        // Then
        assertThat(orbits).isEqualTo(4);
    }
}