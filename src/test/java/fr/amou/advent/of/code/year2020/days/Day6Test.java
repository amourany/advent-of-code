package fr.amou.advent.of.code.year2020.days;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day6Test {

    @Test
    void part1_example1() {
        // Given
        List<String> groupAnswer = List.of("abc");

        // When
        Integer result = Day6.countYesAnswerInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void part1_example2() {
        // Given
        List<String> groupAnswer = List.of("a", "b", "c");

        // When
        Integer result = Day6.countYesAnswerInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void part1_example3() {
        // Given
        List<String> groupAnswer = List.of("ab", "ac");

        // When
        Integer result = Day6.countYesAnswerInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void part1_example4() {
        // Given
        List<String> groupAnswer = List.of("a", "a", "a", "a");

        // When
        Integer result = Day6.countYesAnswerInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void part1_example5() {
        // Given
        List<String> groupAnswer = List.of("b");

        // When
        Integer result = Day6.countYesAnswerInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(1);
    }
}