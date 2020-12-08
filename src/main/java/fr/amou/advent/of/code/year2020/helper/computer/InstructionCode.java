package fr.amou.advent.of.code.year2020.helper.computer;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum InstructionCode {
    ACC("acc"),
    JMP("jmp"),
    NOP("nop");

    private final String value;

    InstructionCode(String value) {
        this.value = value;
    }

    public static InstructionCode getEnumFromValue(String value) {
        return Arrays.stream(InstructionCode.values())
                .filter(entry -> StringUtils.equals(entry.value, value))
                .findFirst()
                .orElse(NOP);
    }
}
