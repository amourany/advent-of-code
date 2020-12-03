package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeProgram;

import java.util.function.Function;

import static fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction.*;

public abstract class AbstractInstructionCode implements InstructionCode {

    protected final IntCodeInstruction instructionAndOptions;

    protected AbstractInstructionCode(IntCodeInstruction instructionAndOptions) {
        this.instructionAndOptions = instructionAndOptions;
    }

    protected Function<IntCodeProgram, Integer> getFirstParameter() {
        return intCodeProgram -> instructionAndOptions.getParameterResolverFunction(INSTRUCTION_PARAM_1_MODE)
                .apply(intCodeProgram, intCodeProgram.getFirstParameterIndex());
    }

    protected Function<IntCodeProgram, Integer> getSecondParameter() {
        return intCodeProgram -> instructionAndOptions.getParameterResolverFunction(INSTRUCTION_PARAM_2_MODE)
                .apply(intCodeProgram, intCodeProgram.getSecondParameterIndex());
    }

    protected Function<IntCodeProgram, Integer> getThirdParameter() {
        return intCodeProgram -> instructionAndOptions.getParameterResolverFunction(INSTRUCTION_PARAM_3_MODE)
                .apply(intCodeProgram, intCodeProgram.getThirdParameterIndex());
    }
}
