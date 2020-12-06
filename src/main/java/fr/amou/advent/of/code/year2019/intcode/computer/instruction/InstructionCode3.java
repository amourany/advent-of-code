package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;

import java.util.function.Consumer;
import java.util.function.Function;

import static fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction.INSTRUCTION_PARAM_1_MODE;

public class InstructionCode3 extends AbstractInstructionCode {

    public InstructionCode3(IntCodeInstruction instructionAndOptions) {
        super(instructionAndOptions);
    }

    @Override
    public Consumer<IntCodeComputer> execute() {
        return intCodeComputer -> {
            Double storeLocation = getStoreLocation().apply(intCodeComputer);

            intCodeComputer.storeInputValue(storeLocation.intValue());
            intCodeComputer.moveCursor(2);
        };
    }

    protected Function<IntCodeComputer, Double> getStoreLocation() {
        return intCodeComputer -> instructionAndOptions.getStoreLocation(INSTRUCTION_PARAM_1_MODE)
                .apply(intCodeComputer, intCodeComputer.getFirstParameterIndex());
    }
}
