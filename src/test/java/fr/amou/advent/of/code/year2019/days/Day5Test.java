package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
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

        List<Double> instructionsList = new ArrayList<>(List.of(3d, 9d, 8d, 9d, 10d, 9d, 4d, 9d, 99d, -1d, 8d));
        IntCodeComputer computer = new IntCodeComputer();

        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(8d)))
                .get(0)).isEqualTo(1);
        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(9d)))
                .get(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("For 3,9,7,9,10,9,4,9,99,-1,8, position mode, input 8")
    void part2Example2() {

        List<Double> instructionsList = new ArrayList<>(List.of(3d, 9d, 7d, 9d, 10d, 9d, 4d, 9d, 99d, -1d, 8d));

        IntCodeComputer computer = new IntCodeComputer();

        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(7d)))
                .get(0)).isEqualTo(1);
        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(9d)))
                .get(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("For 3,3,1108,-1,8,3,4,3,99, immediate mode, input 8")
    void part2Example3() {

        List<Double> instructionsList = new ArrayList<>(List.of(3d, 3d, 1108d, -1d, 8d, 3d, 4d, 3d, 99d));

        IntCodeComputer computer = new IntCodeComputer();

        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(8d)))
                .get(0)).isEqualTo(1);
        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(9d)))
                .get(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("For 3,3,1107,-1,8,3,4,3,99, immediate mode, input 8")
    void part2Example4() {

        List<Double> instructionsList = new ArrayList<>(List.of(3d, 3d, 1107d, -1d, 8d, 3d, 4d, 3d, 99d));

        IntCodeComputer computer = new IntCodeComputer();

        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(7d)))
                .get(0)).isEqualTo(1);
        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(9d)))
                .get(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("For 3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9, position mode, input 0")
    void part2Example5() {

        List<Double> instructionsList = new ArrayList<>(
                List.of(3d, 12d, 6d, 12d, 15d, 1d, 13d, 14d, 13d, 4d, 13d, 99d, -1d, 0d, 1d, 9d));

        IntCodeComputer computer = new IntCodeComputer();

        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(0d)))
                .get(0)).isEqualTo(0);
        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(2d)))
                .get(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("For 3,3,1105,-1,9,1101,0,0,12,4,12,99,1, immediate mode, input 0")
    void part2Example6() {

        List<Double> instructionsList = new ArrayList<>(
                List.of(3d, 3d, 1105d, -1d, 9d, 1101d, 0d, 0d, 12d, 4d, 12d, 99d, 1d));

        IntCodeComputer computer = new IntCodeComputer();

        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(0d)))
                .get(0)).isEqualTo(0);
        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(2d)))
                .get(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("For 3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,\n" + "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,\n" + "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99, immediate mode, input 8")
    void part2Example7() {

        List<Double> instructionsList = new ArrayList<>(
                List.of(3d, 21d, 1008d, 21d, 8d, 20d, 1005d, 20d, 22d, 107d, 8d, 21d, 20d, 1006d, 20d, 31d, 1106d, 0d,
                        36d, 98d, 0d, 0d, 1002d, 21d, 125d, 20d, 4d, 20d, 1105d, 1d, 46d, 104d, 999d, 1105d, 1d, 46d,
                        1101d, 1000d, 1d, 20d, 4d, 20d, 1105d, 1d, 46d, 98d, 99d));

        IntCodeComputer computer = new IntCodeComputer();

        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(7d)))
                .get(0)).isEqualTo(999);
        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(8d)))
                .get(0)).isEqualTo(1000);
        assertThat(computer.run(instructionsList, new ArrayList<>(List.of(9d)))
                .get(0)).isEqualTo(1001);
    }
}
