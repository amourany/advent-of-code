package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;

import java.util.function.Consumer;

public class InstructionCode5 extends AbstractInstructionCode {

    public InstructionCode5(IntCodeInstruction instructionAndOptions) {
        super(instructionAndOptions);
    }

    @Override
    public Consumer<IntCodeComputer> execute() {
        return intCodeComputer -> {
            Double firstParameter = getFirstParameter().apply(intCodeComputer);
            Double secondParameter = getSecondParameter().apply(intCodeComputer);

            if (firstParameter.compareTo(0d) != 0) {
                intCodeComputer.moveCursorToIndex(secondParameter.intValue());
            } else {
                intCodeComputer.moveCursor(3);
            }
        };
    }
}
