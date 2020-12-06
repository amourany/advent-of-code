package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.Day2019;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day9 extends Day2019 {

    public Day9() {
        super(9);
    }

    public static void main(String[] args) throws IOException {
        new Day9().printParts();
    }

    @Override
    public Object part1() throws IOException {
        List<String> dataStringList = readDataAsList();
        List<Double> dataIntegerList = dataStringList.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .map(Double::valueOf)
                .collect(Collectors.toList());

        IntCodeComputer computer = new IntCodeComputer();
        Double output = computer.run(dataIntegerList, List.of(1d))
                .get(0);
        return String.format("%.0f", output);
    }

    @Override
    public Object part2() throws IOException {
        List<String> dataStringList = readDataAsList();
        List<Double> dataIntegerList = dataStringList.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .map(Double::valueOf)
                .collect(Collectors.toList());

        IntCodeComputer computer = new IntCodeComputer();
        Double output = computer.run(dataIntegerList, List.of(2d))
                .get(0);
        return String.format("%.0f", output);
    }
}
