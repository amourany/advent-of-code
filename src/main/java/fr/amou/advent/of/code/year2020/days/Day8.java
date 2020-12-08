package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static fr.amou.advent.of.code.year2020.days.Day8.ProgramStatus.COMPLETED;
import static fr.amou.advent.of.code.year2020.days.Day8.ProgramStatus.RUNNING;

public class Day8 extends Day2020 {

    public Day8() {
        super(8);
    }

    public static void main(String[] args) throws IOException {
        new Day8().printParts();
    }

    public static Integer runProgram(List<String> program) {
        Integer accumulatorValue = 0;
        Integer currentPosition = 0;
        ProgramStatus programStatus = RUNNING;
        String[] programInstructions = program.toArray(new String[0]);
        Set<Integer> positionsRun = new HashSet<>();

        while (programStatus == RUNNING) {
            String[] instruction = programInstructions[currentPosition].split(" ");

            if (positionsRun.contains(currentPosition)) {
                programStatus = COMPLETED;
            } else {

                positionsRun.add(currentPosition);

                switch (instruction[0]) {
                    case "acc":
                        accumulatorValue += Integer.parseInt(instruction[1]);
                        currentPosition++;
                        break;
                    case "jmp":
                        currentPosition += Integer.parseInt(instruction[1]);
                        break;
                    case "nop":
                        currentPosition++;
                        break;
                    default:
                        currentPosition++;
                        break;
                }
            }
        }

        return accumulatorValue;
    }

    @Override
    public Object part1() throws IOException {
        List<String> program = readDataAsList();
        return runProgram(program);
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }

    enum ProgramStatus {
        RUNNING,
        COMPLETED
    }
}
