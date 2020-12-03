package fr.amou.advent.of.code.year2019.intcode.computer;

import fr.amou.advent.of.code.year2019.intcode.computer.instruction.InstructionCode;
import fr.amou.advent.of.code.year2019.intcode.computer.instruction.InstructionCodeResolver;

import static fr.amou.advent.of.code.year2019.intcode.computer.ProgramStatus.RUNNING;

public class IntCodeComputer {

    public Integer runIntCodeProgram(IntCodeProgram intCodeProgram) {

        while (intCodeProgram.getProgramStatus() == RUNNING) {

            IntCodeInstruction currentInstructionAndOptions = intCodeProgram.getCurrentInstructionAndOptions();

            InstructionCode codeStep = InstructionCodeResolver.resolveInstructionCode(currentInstructionAndOptions);

            codeStep.execute()
                    .accept(intCodeProgram);
        }

        return intCodeProgram.getOutputValue();
    }
}
