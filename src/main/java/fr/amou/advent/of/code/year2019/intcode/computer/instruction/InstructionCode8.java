package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;

import java.util.function.Consumer;
import java.util.function.Function;

import static fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction.INSTRUCTION_PARAM_3_MODE;

public class InstructionCode8 extends AbstractInstructionCode {

    public InstructionCode8(IntCodeInstruction instructionAndOptions) {
        super(instructionAndOptions);
    }

    @Override
    public Consumer<IntCodeComputer> execute() {
        return intCodeProgram -> {
            Double firstParameter = getFirstParameter().apply(intCodeProgram);
            Double secondParameter = getSecondParameter().apply(intCodeProgram);
            Double storeLocation = getStoreLocation().apply(intCodeProgram);

            int codeExecutionResult = firstParameter.equals(secondParameter) ? 1 : 0;

            intCodeProgram.store(storeLocation.intValue(), (double) codeExecutionResult);
            intCodeProgram.moveCursor(4);
        };
    }

    protected Function<IntCodeComputer, Double> getStoreLocation() {
        return intCodeComputer -> instructionAndOptions.getStoreLocation(INSTRUCTION_PARAM_3_MODE)
                .apply(intCodeComputer, intCodeComputer.getThirdParameterIndex());
    }
}
