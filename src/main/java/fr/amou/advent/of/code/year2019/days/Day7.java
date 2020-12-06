package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.Day2019;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
public class Day7 extends Day2019 {

    public Day7() {
        super(7);
    }

    public static void main(String[] args) throws IOException {
        new Day7().printParts();
    }

    public static Double computeMaxThrusterSignal(List<Double> programInstructions) {
        return generatePermutations(List.of(0, 1, 2, 3, 4), 5).map(
                phaseSettings -> chainedComputers(programInstructions, phaseSettings.toArray(new Integer[5])))
                .reduce(0d, Math::max);
    }

    private static Double chainedComputers(List<Double> programInstructions, Integer[] phaseSettings) {
        IntCodeComputer computer = new IntCodeComputer();

        Double nextInputValue = computer.run(programInstructions, List.of(phaseSettings[0].doubleValue(), 0d))
                .get(0);
        nextInputValue = computer.run(programInstructions, List.of(phaseSettings[1].doubleValue(), nextInputValue))
                .get(0);
        nextInputValue = computer.run(programInstructions, List.of(phaseSettings[2].doubleValue(), nextInputValue))
                .get(0);
        nextInputValue = computer.run(programInstructions, List.of(phaseSettings[3].doubleValue(), nextInputValue))
                .get(0);
        return computer.run(programInstructions, List.of(phaseSettings[4].doubleValue(), nextInputValue))
                .get(0);
    }

    private static Stream<List<Integer>> generatePermutations(List<Integer> availablePhaseNumbers,
                                                              int remainingPhaseDigit) {
        if (remainingPhaseDigit == 1) {
            return availablePhaseNumbers.stream()
                    .map(List::of);
        }

        return availablePhaseNumbers.stream()
                .map(digit -> generatePermutations(availablePhaseNumbers, remainingPhaseDigit - 1).filter(
                        childList -> !childList.contains(digit))
                        .map(childList -> {
                            List<Integer> newList = new ArrayList<>(childList);
                            newList.add(digit);
                            return newList;
                        })
                        .collect(Collectors.toList()))
                .flatMap(List::stream);
    }

    @Override
    public Object part1() throws IOException {
        List<String> dataStringList = readDataAsList();
        List<Double> dataIntegerList = dataStringList.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .map(Double::valueOf)
                .collect(Collectors.toList());

        return computeMaxThrusterSignal(dataIntegerList);
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }
}
