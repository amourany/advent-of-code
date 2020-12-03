package fr.amou.advent.of.code.year2019.intcode.computer;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static fr.amou.advent.of.code.year2019.intcode.computer.ProgramStatus.RUNNING;

public class IntCodeProgram {

    private final List<Integer> program;

    @Setter
    private List<Integer> inputValues;

    @Getter
    @Setter
    private int outputValue;

    @Getter
    @Setter
    private ProgramStatus programStatus = RUNNING;

    private int currentIndex = 0;

    public IntCodeProgram(List<Integer> program, int inputValue) {
        this.program = new ArrayList<>(program);
        this.inputValues = List.of(inputValue);
    }

    public IntCodeProgram(List<Integer> program, List<Integer> inputValues) {
        this.program = new ArrayList<>(program);
        this.inputValues = inputValues;
    }

    public IntCodeInstruction getCurrentInstructionAndOptions() {
        return new IntCodeInstruction(program.get(currentIndex));
    }

    public Integer getFirstParameterIndex() {
        return currentIndex + 1;
    }

    public Integer getSecondParameterIndex() {
        return currentIndex + 2;
    }

    public Integer getThirdParameterIndex() {
        return currentIndex + 3;
    }

    public void store(int storeLocation, int storeValue) {
        program.set(storeLocation, storeValue);
    }

    public void storeInputValue(Integer storeLocation) {
        Integer value = inputValues.get(0);
        program.set(storeLocation, value);

        if (inputValues.size() > 1) {
            inputValues = inputValues.subList(1, inputValues.size());
        }
    }

    public void moveCursor(int steps) {
        currentIndex += steps;
    }

    public void moveCursorToIndex(int newIndex) {
        currentIndex = newIndex;
    }

    public Integer get(int i) {
        return program.get(i);
    }
}
