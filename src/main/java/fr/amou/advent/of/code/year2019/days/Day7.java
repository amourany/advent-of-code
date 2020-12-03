package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.Day2019;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeProgram;
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

    public static Integer computeMaxThrusterSignal(List<Integer> dataIntegerList) {
        return generatePermutations(List.of(0, 1, 2, 3, 4), 5).map(
                phaseSettings -> chainedComputers(dataIntegerList, phaseSettings.toArray(new Integer[5])))
                .reduce(0, Math::max);
    }

    private static Integer chainedComputers(List<Integer> dataIntegerList, Integer[] phaseSettings) {
        IntCodeComputer computer = new IntCodeComputer();

        IntCodeProgram intCodeProgram = new IntCodeProgram(dataIntegerList, List.of(phaseSettings[0], 0));
        int nextInputValue = computer.runIntCodeProgram(intCodeProgram);

        intCodeProgram = new IntCodeProgram(dataIntegerList, List.of(phaseSettings[1], nextInputValue));
        nextInputValue = computer.runIntCodeProgram(intCodeProgram);

        intCodeProgram = new IntCodeProgram(dataIntegerList, List.of(phaseSettings[2], nextInputValue));
        nextInputValue = computer.runIntCodeProgram(intCodeProgram);

        intCodeProgram = new IntCodeProgram(dataIntegerList, List.of(phaseSettings[3], nextInputValue));
        nextInputValue = computer.runIntCodeProgram(intCodeProgram);

        intCodeProgram = new IntCodeProgram(dataIntegerList, List.of(phaseSettings[4], nextInputValue));
        return computer.runIntCodeProgram(intCodeProgram);
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
        List<Integer> dataIntegerList = dataStringList.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return computeMaxThrusterSignal(dataIntegerList);
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }
}
