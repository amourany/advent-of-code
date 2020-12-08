package fr.amou.advent.of.code.year2020.helper.computer;

import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static fr.amou.advent.of.code.year2020.helper.computer.ProgramStatus.*;

public class Computer {

    @Getter
    private Integer accumulatorValue;

    private Instruction[] program;

    @Getter
    private ProgramStatus programStatus;

    public void loadProgram(List<Instruction> rawProgram) {
        program = rawProgram.toArray(Instruction[]::new);
        accumulatorValue = 0;
        programStatus = RUNNING;
    }

    public void run() {
        int currentPosition = 0;
        Set<Integer> positionsRun = new HashSet<>();

        while (programStatus == RUNNING) {

            if (positionsRun.contains(currentPosition)) {
                programStatus = INFINITE;
            } else if (currentPosition >= program.length) {
                programStatus = COMPLETED;
            } else {

                Instruction instruction = program[currentPosition];
                positionsRun.add(currentPosition);

                switch (instruction.getCode()) {
                    case ACC:
                        accumulatorValue += instruction.getParam();
                        currentPosition++;
                        break;
                    case JMP:
                        currentPosition += instruction.getParam();
                        break;
                    case NOP:
                    default:
                        currentPosition++;
                        break;
                }
            }
        }
    }

    public static class ComputerBuilder {

        private Computer computer;

        public static ComputerBuilder aComputer() {
            ComputerBuilder builder = new ComputerBuilder();
            builder.computer = new Computer();

            return builder;
        }

        public ComputerBuilder withProgramToParse(List<String> program) {
            computer.loadProgram(program.stream()
                    .map(Instruction::new)
                    .collect(Collectors.toList()));
            return this;
        }

        public ComputerBuilder withProgram(List<Instruction> program) {
            computer.loadProgram(program);
            return this;
        }

        public Computer start() {
            computer.run();
            return computer;
        }
    }
}
