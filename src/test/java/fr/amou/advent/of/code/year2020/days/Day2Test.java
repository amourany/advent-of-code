package fr.amou.advent.of.code.year2020.days;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {

    @Test
    @DisplayName("1-3 a: abcde should be valid")
    void part1_exemple1() {
        // Given
        String passwordPolicy = "1-3 a: abcde";

        // When
        long validPasswords = Day2.countValidPasswords(List.of(passwordPolicy), Day2::checkPasswordPart1);

        // Then
        assertThat(validPasswords).isEqualTo(1);
    }

    @Test
    @DisplayName("1-3 b: cdefg should not be valid")
    void part1_exemple2() {
        // Given
        String passwordPolicy = "1-3 b: cdefg";

        // When
        long validPasswords = Day2.countValidPasswords(List.of(passwordPolicy), Day2::checkPasswordPart1);

        // Then
        assertThat(validPasswords).isZero();
    }

    @Test
    @DisplayName("2-9 c: ccccccccc should be valid")
    void part1_exemple3() {
        // Given
        String passwordPolicy = "2-9 c: ccccccccce";

        // When
        long validPasswords = Day2.countValidPasswords(List.of(passwordPolicy), Day2::checkPasswordPart1);

        // Then
        assertThat(validPasswords).isEqualTo(1);
    }

    @Test
    @DisplayName("1-3 a: abcde should be valid")
    void part2_exemple1() {
        // Given
        String passwordPolicy = "1-3 a: abcde";

        // When
        long validPasswords = Day2.countValidPasswords(List.of(passwordPolicy), Day2::checkPasswordPart2);

        // Then
        assertThat(validPasswords).isEqualTo(1);
    }

    @Test
    @DisplayName("1-3 b: cdefg should not be valid")
    void part2_exemple2() {
        // Given
        String passwordPolicy = "1-3 b: cdefg";

        // When
        long validPasswords = Day2.countValidPasswords(List.of(passwordPolicy), Day2::checkPasswordPart2);

        // Then
        assertThat(validPasswords).isZero();
    }

    @Test
    @DisplayName("2-9 c: ccccccccc should not be valid")
    void part2_exemple3() {
        // Given
        String passwordPolicy = "2-9 c: ccccccccc";

        // When
        long validPasswords = Day2.countValidPasswords(List.of(passwordPolicy), Day2::checkPasswordPart2);

        // Then
        assertThat(validPasswords).isZero();
    }
}