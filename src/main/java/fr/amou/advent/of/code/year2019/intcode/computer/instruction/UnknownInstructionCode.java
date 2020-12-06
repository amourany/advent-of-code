package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;

import java.util.function.Consumer;

public class UnknownInstructionCode implements InstructionCode {

    @Override
    public Consumer<IntCodeComputer> execute() {
        return intCodeComputer -> {
        };
    }
}
