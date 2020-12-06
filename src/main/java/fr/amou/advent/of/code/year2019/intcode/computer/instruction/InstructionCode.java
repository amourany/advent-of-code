package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;

import java.util.function.Consumer;

public interface InstructionCode {

    Consumer<IntCodeComputer> execute();
}
