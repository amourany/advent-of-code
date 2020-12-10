package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class Day10 extends Day2020 {

    public Day10() {
        super(10);
    }

    public static void main(String[] args) throws IOException {
        new Day10().printParts();
    }

    public static Map<Integer, Integer> findAdapterChainDifferences(List<Integer> adapterList) {

        List<Integer> sortedAdapterList = addFirstAndLastAdapters(adapterList);

        Map<Integer, Integer> adapterDifferences = new HashMap<>();

        IntStream.range(1, sortedAdapterList.size())
                .boxed()
                .forEach(index -> {
                    Integer adapterDifference = sortedAdapterList.get(index) - sortedAdapterList.get(index - 1);
                    Integer differenceCount = Optional.ofNullable(adapterDifferences.get(adapterDifference))
                            .map(diffCount -> diffCount + 1)
                            .orElse(1);
                    adapterDifferences.put(adapterDifference, differenceCount);
                });

        return adapterDifferences;
    }

    private static List<Integer> addFirstAndLastAdapters(List<Integer> adapterList) {
        Integer maxAdapterValue = adapterList.stream()
                .max(Integer::compareTo)
                .get();

        return Stream.concat(Stream.of(0, maxAdapterValue + 3), adapterList.stream())
                .sorted()
                .collect(Collectors.toList());
    }

    private static Map<Integer, Adapter> convertToMap(List<Integer> adapterList) {
        return adapterList.stream()
                .map(jolt -> entry(jolt, new Adapter(jolt)))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public static Double countAllPermutations(List<Integer> adapters) {
        List<Integer> adaptersWithFirstAndLastEntries = addFirstAndLastAdapters(adapters);
        Map<Integer, Adapter> adapterBaseForPermutations = convertToMap(adaptersWithFirstAndLastEntries);

        adapterBaseForPermutations.values()
                .forEach(adapter -> adapter.setConnections(adapterBaseForPermutations));
        return adapterBaseForPermutations.get(0)
                .getNbOfPermutations();
    }

    @Override
    public Object part1() throws IOException {
        List<Integer> adapterList = readDataAsInteger();
        Map<Integer, Integer> adapterChainDifferences = Day10.findAdapterChainDifferences(adapterList);

        Integer diffOf1 = adapterChainDifferences.get(1);
        Integer diffOf3 = adapterChainDifferences.get(3);

        return diffOf1 * diffOf3;
    }

    @Override
    public Object part2() throws IOException {
        List<Integer> adapterList = readDataAsInteger();
        Double nbOfPermutations = Day10.countAllPermutations(adapterList);
        return String.format("%.0f", nbOfPermutations);
    }

    static class Adapter {

        private final Integer jolts;
        private List<Adapter> possibleConnections;
        private Double nbOfPermutations;

        public Adapter(Integer jolts) {
            this.jolts = jolts;
        }

        public void setConnections(Map<Integer, Adapter> adapterMap) {
            possibleConnections = IntStream.rangeClosed(1, 3)
                    .boxed()
                    .map(nextValueOffset -> Optional.ofNullable(adapterMap.get(jolts + nextValueOffset))
                            .orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }

        public Double getNbOfPermutations() {
            if (nbOfPermutations != null) {
                return nbOfPermutations;
            }

            if (possibleConnections.isEmpty()) {
                return 1d;
            }

            nbOfPermutations = possibleConnections.stream()
                    .mapToDouble(Adapter::getNbOfPermutations)
                    .sum();

            return nbOfPermutations;
        }
    }
}
