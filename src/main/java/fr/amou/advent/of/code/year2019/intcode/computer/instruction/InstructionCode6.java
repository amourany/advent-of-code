package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;

import java.util.function.Consumer;

public class InstructionCode6 extends AbstractInstructionCode {

    public InstructionCode6(IntCodeInstruction instructionAndOptions) {
        super(instructionAndOptions);
    }

    @Override
    public Consumer<IntCodeComputer> execute() {
        return intCodeProgram -> {
            Double firstParameter = getFirstParameter().apply(intCodeProgram);
            Double secondParameter = getSecondParameter().apply(intCodeProgram);

            if (firstParameter.compareTo(0d) == 0) {
                intCodeProgram.moveCursorToIndex(secondParameter.intValue());
            } else {
                intCodeProgram.moveCursor(3);
            }
        };
    }
}
