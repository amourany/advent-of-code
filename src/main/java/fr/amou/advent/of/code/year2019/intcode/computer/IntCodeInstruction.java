package fr.amou.advent.of.code.year2019.intcode.computer;

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

    private static final BiFunction<IntCodeProgram, Integer, Integer> POSITION_MODE_FUNCTION = (intCodeProgram, index) -> (intCodeProgram.get(
            intCodeProgram.get(index)));
    private static final BiFunction<IntCodeProgram, Integer, Integer> IMMEDIATE_MODE_FUNCTION = IntCodeProgram::get;

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

    public BiFunction<IntCodeProgram, Integer, Integer> getParameterResolverFunction(int paramNumber) {
        return instructionOptions[paramNumber] == POSITION_MODE ? POSITION_MODE_FUNCTION : IMMEDIATE_MODE_FUNCTION;
    }
}
