package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;

import java.util.function.Consumer;
import java.util.function.Function;

import static fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction.INSTRUCTION_PARAM_3_MODE;

public class InstructionCode7 extends AbstractInstructionCode {

    public InstructionCode7(IntCodeInstruction instructionAndOptions) {
        super(instructionAndOptions);
    }

    @Override
    public Consumer<IntCodeComputer> execute() {
        return intCodeComputer -> {
            Double firstParameter = getFirstParameter().apply(intCodeComputer);
            Double secondParameter = getSecondParameter().apply(intCodeComputer);
            Double storeLocation = getStoreLocation().apply(intCodeComputer);

            int codeExecutionResult = firstParameter < secondParameter ? 1 : 0;

            intCodeComputer.store(storeLocation.intValue(), (double) codeExecutionResult);
            intCodeComputer.moveCursor(4);
        };
    }

    protected Function<IntCodeComputer, Double> getStoreLocation() {
        return intCodeComputer -> instructionAndOptions.getStoreLocation(INSTRUCTION_PARAM_3_MODE)
                .apply(intCodeComputer, intCodeComputer.getThirdParameterIndex());
    }
}
