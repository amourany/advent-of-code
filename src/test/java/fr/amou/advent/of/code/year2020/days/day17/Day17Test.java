package fr.amou.advent.of.code.year2020.days.day17;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day17Test {

    @Test
    void part1_example1() {
        // Given
        String initialState = ".#.\n..#\n###";

        // When
        long actives = Day17.simulateAndCountActives(initialState, 6);

        // Then
        assertThat(actives).isEqualTo(112);
    }
}