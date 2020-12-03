package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.Day2020;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
public class Day1 extends Day2020 {

    public Day1() {
        super(1);
    }

    public static void main(String[] args) throws IOException {
        new Day1().printParts();
    }

    public static int fixExpenseReport(List<Integer> expenseReport, int digitsToFind) {

        Stream<List<Integer>> allCandidates = generatePermutations(expenseReport, digitsToFind - 1);
        return allCandidates.filter(oneCandidate -> oneCandidate.stream()
                .reduce(0, Integer::sum) == 2020)
                .map(foundCandidate -> foundCandidate.stream()
                        .reduce(1, Math::multiplyExact))
                .findFirst()
                .get();
    }

    private static Stream<List<Integer>> generatePermutations(List<Integer> expenseReport, int remainingDigitsToFind) {
        if (remainingDigitsToFind == 0) {
            return expenseReport.stream()
                    .map(List::of);
        }

        return expenseReport.stream()
                .map(digit -> generatePermutations(expenseReport, remainingDigitsToFind - 1).map(childList -> {
                    List<Integer> newList = new ArrayList<>(childList);
                    newList.add(digit);
                    return newList;
                })
                        .collect(Collectors.toList()))
                .flatMap(List::stream);
    }

    @Override
    public Object part1() throws IOException {
        List<Integer> part1Input = readDataAsInteger();
        return fixExpenseReport(part1Input, 2);
    }

    @Override
    public Object part2() throws IOException {
        List<Integer> part1Input = readDataAsInteger();
        return fixExpenseReport(part1Input, 3);
    }
}
