package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeProgram;

import java.util.function.Consumer;
import java.util.function.Function;

public class InstructionCode1 extends AbstractInstructionCode {

    public InstructionCode1(IntCodeInstruction instructionAndOptions) {
        super(instructionAndOptions);
    }

    @Override
    public Consumer<IntCodeProgram> execute() {
        return intCodeProgram -> {

            Integer firstParameter = getFirstParameter().apply(intCodeProgram);
            Integer secondParameter = getSecondParameter().apply(intCodeProgram);
            Integer storeLocation = getStoreLocation().apply(intCodeProgram);

            intCodeProgram.store(storeLocation, firstParameter + secondParameter);
            intCodeProgram.moveCursor(4);
        };
    }

    private Function<IntCodeProgram, Integer> getStoreLocation() {
        return intCodeProgram -> intCodeProgram.get(intCodeProgram.getThirdParameterIndex());
    }
}
