package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;

import java.util.function.Consumer;

public class InstructionCode4 extends AbstractInstructionCode {

    public InstructionCode4(IntCodeInstruction instructionAndOptions) {
        super(instructionAndOptions);
    }

    @Override
    public Consumer<IntCodeComputer> execute() {
        return intCodeComputer -> {
            Double firstParameter = getFirstParameter().apply(intCodeComputer);

            intCodeComputer.addOutputValue(firstParameter);
            intCodeComputer.moveCursor(2);
        };
    }
}
