package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.Day2019;
import fr.amou.advent.of.code.year2019.intcode.computer.IntCodeComputer;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class Day5 extends Day2019 {

    public Day5() {
        super(5);
    }

    public static void main(String[] args) throws IOException {
        new Day5().printParts();
    }

    private static Double runComputer(List<Double> dataIntegerList, Double input) {
        IntCodeComputer computer = new IntCodeComputer();
        return computer.run(dataIntegerList, List.of(input))
                .get(0);
    }

    @Override
    public Object part1() throws IOException {
        List<String> dataStringList = readDataAsList();
        List<Double> dataIntegerList = dataStringList.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .map(Double::valueOf)
                .collect(Collectors.toList());

        return runComputer(dataIntegerList, 1d);
    }

    @Override
    public Object part2() throws IOException {
        List<String> dataStringList = readDataAsList();
        List<Double> dataIntegerList = dataStringList.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .map(Double::valueOf)
                .collect(Collectors.toList());

        return runComputer(dataIntegerList, 2d);
    }
}
