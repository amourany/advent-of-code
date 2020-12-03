package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeProgram;

import java.util.function.Consumer;

public class InstructionCode4 extends AbstractInstructionCode {

    public InstructionCode4(IntCodeInstruction instructionAndOptions) {
        super(instructionAndOptions);
    }

    @Override
    public Consumer<IntCodeProgram> execute() {
        return intCodeProgram -> {

            Integer firstParameter = getFirstParameter().apply(intCodeProgram);

            intCodeProgram.setOutputValue(firstParameter);
            intCodeProgram.moveCursor(2);
        };
    }
}
