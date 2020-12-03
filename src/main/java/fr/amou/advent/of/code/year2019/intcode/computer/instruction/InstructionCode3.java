package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeProgram;

import java.util.function.Consumer;
import java.util.function.Function;

public class InstructionCode3 extends AbstractInstructionCode {

    public InstructionCode3(IntCodeInstruction instructionAndOptions) {
        super(instructionAndOptions);
    }

    @Override
    public Consumer<IntCodeProgram> execute() {
        return intCodeProgram -> {

            Integer storeLocation = getStoreLocation().apply(intCodeProgram);

            intCodeProgram.storeInputValue(storeLocation);
            intCodeProgram.moveCursor(2);
        };
    }

    private Function<IntCodeProgram, Integer> getStoreLocation() {
        return intCodeProgram -> intCodeProgram.get(intCodeProgram.getFirstParameterIndex());
    }
}
