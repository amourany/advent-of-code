package fr.amou.advent.of.code.year2020.days.day6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day6Test {

    @Test
    void part1_example1() {
        // Given
        List<String> groupAnswer = List.of("abc");

        // When
        Integer result = Day6.countYesAnswerForAnyoneInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void part1_example2() {
        // Given
        List<String> groupAnswer = List.of("a", "b", "c");

        // When
        Integer result = Day6.countYesAnswerForAnyoneInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void part1_example3() {
        // Given
        List<String> groupAnswer = List.of("ab", "ac");

        // When
        Integer result = Day6.countYesAnswerForAnyoneInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void part1_example4() {
        // Given
        List<String> groupAnswer = List.of("a", "a", "a", "a");

        // When
        Integer result = Day6.countYesAnswerForAnyoneInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void part1_example5() {
        // Given
        List<String> groupAnswer = List.of("b");

        // When
        Integer result = Day6.countYesAnswerForAnyoneInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void part2_example1() {
        // Given
        List<String> groupAnswer = List.of("abc");

        // When
        Long result = Day6.countYesAnswerForEveryoneInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void part2_example2() {
        // Given
        List<String> groupAnswer = List.of("a", "b", "c");

        // When
        Long result = Day6.countYesAnswerForEveryoneInGroup(groupAnswer);

        // Then
        assertThat(result).isZero();
    }

    @Test
    void part2_example3() {
        // Given
        List<String> groupAnswer = List.of("ab", "ac");

        // When
        Long result = Day6.countYesAnswerForEveryoneInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void part2_example4() {
        // Given
        List<String> groupAnswer = List.of("a", "a", "a", "a");

        // When
        Long result = Day6.countYesAnswerForEveryoneInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void part2_example5() {
        // Given
        List<String> groupAnswer = List.of("b");

        // When
        Long result = Day6.countYesAnswerForEveryoneInGroup(groupAnswer);

        // Then
        assertThat(result).isEqualTo(1);
    }
}