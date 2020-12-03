package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeInstruction;

public class InstructionCodeResolver {

    private InstructionCodeResolver() {
    }

    public static InstructionCode resolveInstructionCode(IntCodeInstruction instructionAndOptions) {

        int code = instructionAndOptions.getCurrentInstruction();

        if (code == 1) {
            return new InstructionCode1(instructionAndOptions);
        } else if (code == 2) {
            return new InstructionCode2(instructionAndOptions);
        } else if (code == 3) {
            return new InstructionCode3(instructionAndOptions);
        } else if (code == 4) {
            return new InstructionCode4(instructionAndOptions);
        } else if (code == 5) {
            return new InstructionCode5(instructionAndOptions);
        } else if (code == 6) {
            return new InstructionCode6(instructionAndOptions);
        } else if (code == 7) {
            return new InstructionCode7(instructionAndOptions);
        } else if (code == 8) {
            return new InstructionCode8(instructionAndOptions);
        } else if (code == 99) {
            return new InstructionCode99(instructionAndOptions);
        }
        return new UnknownInstructionCode();
    }
}
