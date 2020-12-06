package fr.amou.advent.of.code.year2019.intcode.computer;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class IntCodeInstruction {

    public static final int INSTRUCTION_PARAM_3_MODE = 0;
    public static final int INSTRUCTION_PARAM_2_MODE = 1;
    public static final int INSTRUCTION_PARAM_1_MODE = 2;
    public static final int INSTRUCTION_PART_1 = 3;
    public static final int INSTRUCTION_PART_2 = 4;

    public static final int POSITION_MODE = 0;
    public static final int IMMEDIATE_MODE = 1;
    public static final int RELATIVE_MODE = 2;

    private static final BiFunction<IntCodeComputer, Integer, Double> POSITION_MODE_FUNCTION = (intCodeComputer, index) -> intCodeComputer.getMemoryValueAt(
            intCodeComputer.getMemoryValueAt(index)
                    .intValue());
    private static final BiFunction<IntCodeComputer, Integer, Double> IMMEDIATE_MODE_FUNCTION = IntCodeComputer::getMemoryValueAt;
    private static final BiFunction<IntCodeComputer, Integer, Double> RELATIVE_MODE_FUNCTION = (intCodeComputer, index) -> intCodeComputer.getMemoryValueAt(
            intCodeComputer.getRelativeBase()
                    .intValue() + intCodeComputer.getMemoryValueAt(index)
                    .intValue());

    private static final BiFunction<IntCodeComputer, Integer, Double> POSITION_MODE_STORAGE_FUNCTION = IntCodeComputer::getMemoryValueAt;
    private static final BiFunction<IntCodeComputer, Integer, Double> RELATIVE_MODE_STORAGE_FUNCTION = (intCodeComputer, index) -> intCodeComputer.getRelativeBase() + intCodeComputer.getMemoryValueAt(
            index);

    @Getter
    private final Integer[] instructionOptions;

    public IntCodeInstruction(Integer rawInstruction) {
        this.instructionOptions = parseInstruction(rawInstruction);
    }

    private Integer[] parseInstruction(Integer rawInstruction) {
        Integer[] rawInstructionOptions = Arrays.stream(rawInstruction.toString()
                .split(""))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer[] defaultOptions = {0, 0, 0, 0, 0};

        Integer arrayOffset = defaultOptions.length - rawInstructionOptions.length;

        IntStream.range(0, rawInstructionOptions.length)
                .boxed()
                .sorted(Collections.reverseOrder())
                .forEach(j -> defaultOptions[j + arrayOffset] = rawInstructionOptions[j]);

        return defaultOptions;
    }

    public int getCurrentInstruction() {
        return Integer.parseInt(
                instructionOptions[INSTRUCTION_PART_1].toString() + instructionOptions[INSTRUCTION_PART_2].toString());
    }

    public BiFunction<IntCodeComputer, Integer, Double> getParameterResolverFunction(int paramNumber) {
        switch (instructionOptions[paramNumber]) {
            case POSITION_MODE:
                return POSITION_MODE_FUNCTION;
            case IMMEDIATE_MODE:
                return IMMEDIATE_MODE_FUNCTION;
            case RELATIVE_MODE:
                return RELATIVE_MODE_FUNCTION;
            default:
                return (intCodeProgram, integer) -> -1d;
        }
    }

    public BiFunction<IntCodeComputer, Integer, Double> getStoreLocation(int paramNumber) {
        switch (instructionOptions[paramNumber]) {
            case POSITION_MODE:
                return POSITION_MODE_STORAGE_FUNCTION;
            case RELATIVE_MODE:
                return RELATIVE_MODE_STORAGE_FUNCTION;
            default:
                return (intCodeProgram, integer) -> -1d;
        }
    }
}
