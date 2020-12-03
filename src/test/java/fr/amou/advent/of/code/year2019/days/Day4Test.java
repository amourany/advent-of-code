package fr.amou.advent.of.code.year2019.days;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class Day4Test {

    @Test
    @DisplayName("111111 meets these criteria (double 11, never decreases)")
    @Disabled("Part 2 broke part 1 solution")
    void part1Example1() {
        Boolean isValid = Day4.isPasswordValid(111111);
        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("223450 does not meet these criteria (decreasing pair of digits 50)")
    void part1Example2() {
        Boolean isValid = Day4.isPasswordValid(223450);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("123789 does not meet these criteria (no double)")
    void part1Example3() {
        Boolean isValid = Day4.isPasswordValid(123789);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("112233 meets these criteria because the digits never decrease and all repeated digits are exactly two digits long.")
    void part2Example1() {
        Boolean isValid = Day4.isPasswordValid(112233);
        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("123444 no longer meets the criteria (the repeated 44 is part of a larger group of 444).")
    void part2Example2() {
        Boolean isValid = Day4.isPasswordValid(123444);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("111122 meets the criteria (even though 1 is repeated more than twice, it still contains a double 22).")
    void part2Example3() {
        Boolean isValid = Day4.isPasswordValid(111122);
        assertThat(isValid).isTrue();
    }
}
