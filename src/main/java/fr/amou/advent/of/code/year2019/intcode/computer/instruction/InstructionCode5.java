package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeProgram;

import java.util.function.Consumer;

public class InstructionCode5 extends AbstractInstructionCode {

    public InstructionCode5(IntCodeInstruction instructionAndOptions) {
        super(instructionAndOptions);
    }

    @Override
    public Consumer<IntCodeProgram> execute() {
        return intCodeProgram -> {
            Integer firstParameter = getFirstParameter().apply(intCodeProgram);

            Integer secondParameter = getSecondParameter().apply(intCodeProgram);

            if (firstParameter.compareTo(0) != 0) {
                intCodeProgram.moveCursorToIndex(secondParameter);
            } else {
                intCodeProgram.moveCursor(3);
            }
        };
    }
}
