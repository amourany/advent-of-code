package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;

import java.util.function.Consumer;

import static fr.amou.advent.of.code.year2019.intcode.computer.ProgramStatus.COMPLETED;

public class InstructionCode99 extends AbstractInstructionCode {

    protected InstructionCode99(IntCodeInstruction instructionAndOptions) {
        super(instructionAndOptions);
    }

    @Override
    public Consumer<IntCodeComputer> execute() {
        return intCodeComputer -> intCodeComputer.setProgramStatus(COMPLETED);
    }
}
