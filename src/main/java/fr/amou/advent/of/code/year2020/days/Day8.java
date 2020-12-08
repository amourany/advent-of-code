package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.Day2020;
import fr.amou.advent.of.code.year2020.helper.computer.Computer;
import fr.amou.advent.of.code.year2020.helper.computer.Instruction;
import fr.amou.advent.of.code.year2020.helper.computer.InstructionCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.year2020.helper.computer.Computer.ComputerBuilder.aComputer;
import static fr.amou.advent.of.code.year2020.helper.computer.InstructionCode.*;
import static fr.amou.advent.of.code.year2020.helper.computer.ProgramStatus.COMPLETED;

public class Day8 extends Day2020 {

    public Day8() {
        super(8);
    }

    public static void main(String[] args) throws IOException {
        new Day8().printParts();
    }

    public static List<List<Instruction>> generatePermutations(List<Instruction> program) {
        return IntStream.range(0, program.size())
                .filter(index -> program.get(index)
                        .getCode() != ACC)
                .mapToObj(index -> {
                    List<Instruction> newProgramPermutation = new ArrayList<>(program);
                    newProgramPermutation.set(index, permutation(program.get(index)));
                    return newProgramPermutation;
                })
                .collect(Collectors.toList());
    }

    private static Instruction permutation(Instruction instruction) {
        InstructionCode codeSwapped = instruction.getCode() == JMP ? NOP : JMP;
        return new Instruction(codeSwapped, instruction.getParam());
    }

    public static Integer debugProgram(List<String> rawProgram) {
        List<Instruction> program = rawProgram.stream()
                .map(Instruction::new)
                .collect(Collectors.toList());

        List<List<Instruction>> permutations = generatePermutations(program);

        return permutations.stream()
                .map(permutation -> aComputer().withProgram(permutation)
                        .start())
                .filter(computer -> computer.getProgramStatus() == COMPLETED)
                .map(Computer::getAccumulatorValue)
                .findFirst()
                .orElse(0);
    }

    @Override
    public Object part1() throws IOException {
        List<String> program = readDataAsList();
        Computer computer = aComputer().withProgramToParse(program)
                .start();
        return computer.getAccumulatorValue();
    }

    @Override
    public Object part2() throws IOException {
        List<String> program = readDataAsList();
        return debugProgram(program);
    }
}
