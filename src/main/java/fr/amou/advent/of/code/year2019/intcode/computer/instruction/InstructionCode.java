package fr.amou.advent.of.code.year2019.intcode.computer.instruction;

import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeProgram;

import java.util.function.Consumer;

public interface InstructionCode {

    Consumer<IntCodeProgram> execute();
}
