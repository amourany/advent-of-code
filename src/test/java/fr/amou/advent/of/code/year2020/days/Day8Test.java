package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.helper.computer.Computer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static fr.amou.advent.of.code.year2020.days.Day8.debugProgram;
import static fr.amou.advent.of.code.year2020.helper.computer.Computer.ComputerBuilder.aComputer;
import static org.assertj.core.api.Assertions.assertThat;

class Day8Test {

    @Test
    void part1_example1() {
        // Given
        List<String> program = List.of("nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "jmp -4",
                "acc +6");

        // When
        Computer computer = aComputer().withProgramToParse(program)
                .start();

        // Then
        assertThat(computer.getAccumulatorValue()).isEqualTo(5);
    }

    @Test
    void part2_example1() {
        // Given
        List<String> program = List.of("nop +0", "acc +1", "jmp +4", "acc +3", "jmp -3", "acc -99", "acc +1", "jmp -4",
                "acc +6");

        // When
        Integer result = debugProgram(program);

        // Then
        assertThat(result).isEqualTo(8);
    }
}