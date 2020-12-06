package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;

import java.util.function.Function;

import static fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction.*;

public abstract class AbstractInstructionCode implements InstructionCode {

    protected final IntCodeInstruction instructionAndOptions;

    protected AbstractInstructionCode(IntCodeInstruction instructionAndOptions) {
        this.instructionAndOptions = instructionAndOptions;
    }

    protected Function<IntCodeComputer, Double> getFirstParameter() {
        return intCodeComputer -> instructionAndOptions.getParameterResolverFunction(INSTRUCTION_PARAM_1_MODE)
                .apply(intCodeComputer, intCodeComputer.getFirstParameterIndex());
    }

    protected Function<IntCodeComputer, Double> getSecondParameter() {
        return intCodeComputer -> instructionAndOptions.getParameterResolverFunction(INSTRUCTION_PARAM_2_MODE)
                .apply(intCodeComputer, intCodeComputer.getSecondParameterIndex());
    }

    protected Function<IntCodeComputer, Double> getThirdParameter() {
        return intCodeComputer -> instructionAndOptions.getParameterResolverFunction(INSTRUCTION_PARAM_3_MODE)
                .apply(intCodeComputer, intCodeComputer.getThirdParameterIndex());
    }
}
