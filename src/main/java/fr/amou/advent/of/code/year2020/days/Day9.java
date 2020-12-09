package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day9 extends Day2020 {

    public Day9() {
        super(9);
    }

    public static void main(String[] args) throws IOException {
        new Day9().printParts();
    }

    private static Set<Double> generateAllPermutations(List<Double> inputNumbers, int permutationWindow,
                                                       int numberToEvaluateIndex) {
        return IntStream.range(numberToEvaluateIndex - permutationWindow, numberToEvaluateIndex)
                .boxed()
                .flatMap(firstNumberIndex -> IntStream.range(numberToEvaluateIndex - permutationWindow,
                        numberToEvaluateIndex)
                        .boxed()
                        .filter(secondNumberIndex -> !secondNumberIndex.equals(firstNumberIndex))
                        .map(secondNumberIndex -> inputNumbers.get(firstNumberIndex) + inputNumbers.get(
                                secondNumberIndex)))
                .collect(Collectors.toSet());
    }

    public static Double findFirstInvalidNumber(List<Double> inputNumbers, int permutationWindow) {

        return IntStream.range(permutationWindow, inputNumbers.size())
                .boxed()
                .map(index -> {
                    Set<Double> permutations = generateAllPermutations(inputNumbers, permutationWindow, index);
                    return permutations.contains(inputNumbers.get(index)) ? 0 : inputNumbers.get(index);
                })
                .filter(number -> number != 0)
                .findFirst()
                .get();
    }

    private static List<Double> findSequence(List<Double> inputNumbers, Double sumToBeFound, int permutationWindow) {

        Optional<List<Double>> optionalList = IntStream.range(0, inputNumbers.size() - permutationWindow)
                .boxed()
                .map(index -> {
                    List<Double> window = inputNumbers.subList(index, index + permutationWindow);
                    Double sumOfWindow = window.stream()
                            .reduce(0d, Double::sum);
                    return sumOfWindow.equals(sumToBeFound) ? window : new ArrayList<Double>();
                })
                .filter(foundNumbers -> !foundNumbers.isEmpty())
                .findFirst();

        return optionalList.orElseGet(() -> findSequence(inputNumbers, sumToBeFound, permutationWindow + 1));
    }

    public static Double findEncryptionWeakness(List<Double> inputNumbers, int permutationWindow) {
        Double sumToBeFound = findFirstInvalidNumber(inputNumbers, permutationWindow);
        List<Double> foundWindow = findSequence(inputNumbers, sumToBeFound, 2);
        Double minValue = foundWindow.stream()
                .min(Double::compareTo)
                .get();
        Double maxValue = foundWindow.stream()
                .max(Double::compareTo)
                .get();

        return minValue + maxValue;
    }

    @Override
    public Object part1() throws IOException {
        List<Double> data = readDataAsDouble();
        Double firstInvalidNumber = findFirstInvalidNumber(data, 25);
        return String.format("%.0f", firstInvalidNumber);
    }

    @Override
    public Object part2() throws IOException {
        List<Double> data = readDataAsDouble();
        Double weakness = findEncryptionWeakness(data, 25);
        return String.format("%.0f", weakness);
    }
}
