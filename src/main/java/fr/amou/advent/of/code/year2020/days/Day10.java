package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day10 extends Day2020 {

    public Day10() {
        super(10);
    }

    public static void main(String[] args) throws IOException {
        new Day10().printParts();
    }

    public static Map<Integer, Integer> findAdapterChainDifferences(List<Integer> adapterList) {

        Integer maxAdapterValue = adapterList.stream()
                .max(Integer::compareTo)
                .get();

        List<Integer> sortedAdapterList = Stream.concat(Stream.of(0, maxAdapterValue + 3), adapterList.stream())
                .sorted()
                .collect(Collectors.toList());

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
        return null;
    }
}
