package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeProgram;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class Day5Test {

    @Test
    @DisplayName("For 3,9,8,9,10,9,4,9,99,-1,8, position mode, input 8")
    void part2Example1() {

        List<Integer> instructionsList = new ArrayList<>(List.of(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8));
        IntCodeComputer computer = new IntCodeComputer();
        IntCodeProgram program1 = new IntCodeProgram(instructionsList, 8);
        IntCodeProgram program2 = new IntCodeProgram(instructionsList, 9);

        assertThat(computer.runIntCodeProgram(program1)).isEqualTo(1);
        assertThat(computer.runIntCodeProgram(program2)).isEqualTo(0);
    }

    @Test
    @DisplayName("For 3,9,7,9,10,9,4,9,99,-1,8, position mode, input 8")
    void part2Example2() {

        List<Integer> instructionsList = new ArrayList<>(List.of(3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8));

        IntCodeComputer computer = new IntCodeComputer();
        IntCodeProgram program1 = new IntCodeProgram(instructionsList, 7);
        IntCodeProgram program2 = new IntCodeProgram(instructionsList, 9);

        assertThat(computer.runIntCodeProgram(program1)).isEqualTo(1);
        assertThat(computer.runIntCodeProgram(program2)).isEqualTo(0);
    }

    @Test
    @DisplayName("For 3,3,1108,-1,8,3,4,3,99, immediate mode, input 8")
    void part2Example3() {

        List<Integer> instructionsList = new ArrayList<>();
        instructionsList.addAll(List.of(3, 3, 1108, -1, 8, 3, 4, 3, 99));

        IntCodeComputer computer = new IntCodeComputer();
        IntCodeProgram program1 = new IntCodeProgram(instructionsList, 8);
        IntCodeProgram program2 = new IntCodeProgram(instructionsList, 9);

        assertThat(computer.runIntCodeProgram(program1)).isEqualTo(1);
        assertThat(computer.runIntCodeProgram(program2)).isEqualTo(0);
    }

    @Test
    @DisplayName("For 3,3,1107,-1,8,3,4,3,99, immediate mode, input 8")
    void part2Example4() {

        List<Integer> instructionsList = new ArrayList<>();
        instructionsList.addAll(List.of(3, 3, 1107, -1, 8, 3, 4, 3, 99));

        IntCodeComputer computer = new IntCodeComputer();
        IntCodeProgram program1 = new IntCodeProgram(instructionsList, 7);
        IntCodeProgram program2 = new IntCodeProgram(instructionsList, 9);

        assertThat(computer.runIntCodeProgram(program1)).isEqualTo(1);
        assertThat(computer.runIntCodeProgram(program2)).isEqualTo(0);
    }

    @Test
    @DisplayName("For 3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9, position mode, input 0")
    void part2Example5() {

        List<Integer> instructionsList = new ArrayList<>();
        instructionsList.addAll(List.of(3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9));

        IntCodeComputer computer = new IntCodeComputer();
        IntCodeProgram program1 = new IntCodeProgram(instructionsList, 0);
        IntCodeProgram program2 = new IntCodeProgram(instructionsList, 2);

        assertThat(computer.runIntCodeProgram(program1)).isEqualTo(0);
        assertThat(computer.runIntCodeProgram(program2)).isEqualTo(1);
    }

    @Test
    @DisplayName("For 3,3,1105,-1,9,1101,0,0,12,4,12,99,1, immediate mode, input 0")
    void part2Example6() {

        List<Integer> instructionsList = new ArrayList<>();
        instructionsList.addAll(List.of(3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1));

        IntCodeComputer computer = new IntCodeComputer();
        IntCodeProgram program1 = new IntCodeProgram(instructionsList, 0);
        IntCodeProgram program2 = new IntCodeProgram(instructionsList, 2);

        assertThat(computer.runIntCodeProgram(program1)).isEqualTo(0);
        assertThat(computer.runIntCodeProgram(program2)).isEqualTo(1);
    }

    @Test
    @DisplayName("For 3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,\n" + "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,\n" + "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99, immediate mode, input 8")
    void part2Example7() {

        List<Integer> instructionsList = new ArrayList<>();
        instructionsList.addAll(
                List.of(3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31, 1106, 0, 36, 98, 0, 0, 1002,
                        21, 125, 20, 4, 20, 1105, 1, 46, 104, 999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46,
                        98, 99));

        IntCodeComputer computer = new IntCodeComputer();
        IntCodeProgram program1 = new IntCodeProgram(instructionsList, 7);
        IntCodeProgram program2 = new IntCodeProgram(instructionsList, 8);
        IntCodeProgram program3 = new IntCodeProgram(instructionsList, 9);

        assertThat(computer.runIntCodeProgram(program1)).isEqualTo(999);
        assertThat(computer.runIntCodeProgram(program2)).isEqualTo(1000);
        assertThat(computer.runIntCodeProgram(program3)).isEqualTo(1001);
    }
}
