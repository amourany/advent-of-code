package fr.amou.advent.of.code.year2019.days;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day7Test {

    @Test
    @DisplayName("Max thruster signal 43210 (from phase setting sequence 4,3,2,1,0): 3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0")
    void part1Example1() {
        // Given
        List<Integer> instructions = new ArrayList<>(
                List.of(3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0));

        // When
        Integer result = Day7.computeMaxThrusterSignal(instructions);

        // Then
        assertThat(result).isEqualTo(43210);
    }

    @Test
    @DisplayName("Max thruster signal 54321 (from phase setting sequence 0,1,2,3,4): 3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0")
    void part1Example2() {
        // Given
        List<Integer> instructions = new ArrayList<>(
                List.of(3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23, 101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0,
                        0));

        // When
        Integer result = Day7.computeMaxThrusterSignal(instructions);

        // Then
        assertThat(result).isEqualTo(54321);
    }

    @Test
    @DisplayName("Max thruster signal 65210 (from phase setting sequence 1,0,4,3,2): 3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0")
    void part1Example3() {
        // Given
        List<Integer> instructions = new ArrayList<>(
                List.of(3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33, 1002, 33, 7, 33, 1, 33, 31,
                        31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0));

        // When
        Integer result = Day7.computeMaxThrusterSignal(instructions);

        // Then
        assertThat(result).isEqualTo(65210);
    }
}