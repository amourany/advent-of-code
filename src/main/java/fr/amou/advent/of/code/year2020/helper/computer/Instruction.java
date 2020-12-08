package fr.amou.advent.of.code.year2020.helper.computer;

import lombok.Getter;

@Getter
public class Instruction {

    private final InstructionCode code;
    private final Integer param;

    public Instruction(String instruction) {
        String[] parsedInstruction = instruction.split(" ");
        code = InstructionCode.getEnumFromValue(parsedInstruction[0]);
        param = Integer.parseInt(parsedInstruction[1]);
    }

    public Instruction(InstructionCode code, Integer param) {
        this.code = code;
        this.param = param;
    }
}
