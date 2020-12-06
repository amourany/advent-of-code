package fr.amou.advent.of.code.year2019.intcode.computer;

import fr.amou.advent.of.code.year2019.intcode.computer.instruction.InstructionCode;
import fr.amou.advent.of.code.year2019.intcode.computer.instruction.InstructionCodeResolver;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.year2019.intcode.computer.ProgramStatus.RUNNING;

public class IntCodeComputer {

    private List<Double> memory;

    private List<Double> inputValues;

    private List<Double> output;

    @Getter
    private Double relativeBase;

    private Integer currentIndex;

    @Getter
    @Setter
    private ProgramStatus programStatus;

    public IntCodeComputer() {
        initComputer();
    }

    private void initComputer() {
        memory = new ArrayList<>(Collections.nCopies(100000, 0d));
        output = new ArrayList<>();
        currentIndex = 0;
        relativeBase = 0d;
        programStatus = RUNNING;
    }

    public List<Double> run(List<Double> intCodeProgram, List<Double> inputValues) {

        initComputer();

        IntStream.range(0, intCodeProgram.size())
                .boxed()
                .forEach(index -> memory.set(index, intCodeProgram.get(index)));

        this.inputValues = inputValues;

        while (programStatus == RUNNING) {

            IntCodeInstruction currentInstructionAndOptions = getCurrentInstructionAndOptions();

            InstructionCode codeStep = InstructionCodeResolver.resolveInstructionCode(currentInstructionAndOptions);

            codeStep.execute()
                    .accept(this);
        }

        return output;
    }

    public IntCodeInstruction getCurrentInstructionAndOptions() {
        return new IntCodeInstruction(memory.get(currentIndex)
                .intValue());
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

    public void store(int storeLocation, Double storeValue) {
        memory.set(storeLocation, storeValue);
    }

    public void storeInputValue(Integer storeLocation) {
        Double value = inputValues.get(0);
        memory.set(storeLocation, value);

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

    public Double getMemoryValueAt(int index) {
        return memory.get(index);
    }

    public void addToRelativeBase(int toAdd) {
        relativeBase += toAdd;
    }

    public void addOutputValue(Double outputValue) {
        output.add(outputValue);
    }
}
