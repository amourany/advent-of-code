package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day9Test {

    @Test
    @DisplayName("Should output inputed program")
    void part1_example1() {
        // Given
        List<Double> programInstructions = new ArrayList<>(
                List.of(109d, 1d, 204d, -1d, 1001d, 100d, 1d, 100d, 1008d, 100d, 16d, 101d, 1006d, 101d, 0d, 99d));
        IntCodeComputer computer = new IntCodeComputer();

        // When
        List<Double> outputs = computer.run(programInstructions, List.of());

        // Then
        assertThat(outputs).isEqualTo(programInstructions);
    }

    @Test
    @DisplayName("Should output a 16-digit number")
    void part1_example2() {
        // Given
        List<Double> programInstructions = new ArrayList<>(List.of(1102d, 34915192d, 34915192d, 7d, 4d, 7d, 99d, 0d));
        IntCodeComputer computer = new IntCodeComputer();

        // When
        List<Double> outputs = computer.run(programInstructions, List.of());

        // Then
        assertThat(String.format("%.0f", outputs.get(0))).hasSize(16);
    }

    @Test
    @DisplayName("Should output 1125899906842624")
    void part1_example3() {
        // Given
        List<Double> programInstructions = new ArrayList<>(List.of(104d, 1125899906842624d, 99d));
        IntCodeComputer computer = new IntCodeComputer();

        // When
        List<Double> outputs = computer.run(programInstructions, List.of());

        // Then
        assertThat(outputs.get(0)).isEqualTo(1125899906842624d);
    }
}


