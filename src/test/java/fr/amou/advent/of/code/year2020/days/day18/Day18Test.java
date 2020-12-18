package fr.amou.advent.of.code.year2020.days.day18;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day18Test {

    @Test
    void part1_example1() {
        // Given
        String expression = "1 + 2 * 3 + 4 * 5 + 6";

        // When
        Double result = Day18.parseExpression(expression);

        // Then
        assertThat(result).isEqualTo(71);
    }

    @Test
    void part1_example2() {
        // Given
        String expression = "1 + (2 * 3) + (4 * (5 + 6))";

        // When
        Double result = Day18.parseExpression(expression);

        // Then
        assertThat(result).isEqualTo(51);
    }

    @Test
    void part1_example3() {
        // Given
        String expression = "2 * 3 + (4 * 5)";

        // When
        Double result = Day18.parseExpression(expression);

        // Then
        assertThat(result).isEqualTo(26);
    }

    @Test
    void part1_example4() {
        // Given
        String expression = "5 + (8 * 3 + 9 + 3 * 4 * 3)";

        // When
        Double result = Day18.parseExpression(expression);

        // Then
        assertThat(result).isEqualTo(437);
    }

    @Test
    void part1_example5() {
        // Given
        String expression = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";

        // When
        Double result = Day18.parseExpression(expression);

        // Then
        assertThat(result).isEqualTo(12240);
    }

    @Test
    void part1_example6() {
        // Given
        String expression = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";

        // When
        Double result = Day18.parseExpression(expression);

        // Then
        assertThat(result).isEqualTo(13632);
    }
}