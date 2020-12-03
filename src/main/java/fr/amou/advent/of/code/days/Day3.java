package fr.amou.advent.of.code.days;

import fr.amou.advent.of.code.common.Coordinate;
import fr.amou.advent.of.code.common.Day;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.utils.DataReader.readDataAsListForDay;

@Log4j2
public class Day3 implements Day {

    private static final String TREE_SYMBOL = "#";

    public static void main(String[] args) throws IOException {
        Day day = new Day3();
        day.part1();
        day.part2();
    }

    private static Map<Coordinate, String> buildMap(List<String> mapLines) {

        return IntStream.range(0, mapLines.size())
                .boxed()
                .map(yIndex -> {
                    String[] lineSquares = mapLines.get(yIndex)
                            .split("");
                    return IntStream.range(0, lineSquares.length)
                            .boxed()
                            .map(xIndex -> Map.entry(new Coordinate(xIndex, yIndex), lineSquares[xIndex]))
                            .collect(Collectors.toList());
                })
                .flatMap(List::stream)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    private static Long countTrees(Map<Coordinate, String> regionMap, Coordinate pathToFollow) {

        int regionWidth = regionMap.keySet()
                .stream()
                .map(entry -> entry.x)
                .reduce(0, Math::max);
        int regionHeight = regionMap.keySet()
                .stream()
                .map(entry -> entry.y)
                .reduce(0, Math::max);

        int currentXPos = 0;
        int currentYPos = 0;
        Long foundTrees = 0L;

        while (currentYPos < regionHeight) {

            currentXPos = (currentXPos + pathToFollow.x) % (regionWidth + 1);
            currentYPos = (currentYPos + pathToFollow.y);

            Coordinate newCoordinate = new Coordinate(currentXPos, currentYPos);
            if (regionMap.containsKey(newCoordinate) && regionMap.get(newCoordinate)
                    .equals(TREE_SYMBOL)) {
                foundTrees++;
            }
        }

        return foundTrees;
    }

    public static Long followSlope(List<String> mapLines, List<Coordinate> pathsToFollow) {
        Map<Coordinate, String> regionMap = buildMap(mapLines);

        return pathsToFollow.stream()
                .map(path -> countTrees(regionMap, path))
                .reduce(1L, Math::multiplyExact);
    }

    @Override
    public void part1() throws IOException {
        List<String> mapLines = readDataAsListForDay(3);
        List<Coordinate> pathsToFollow = List.of(new Coordinate(3, 1));
        long countedTrees = followSlope(mapLines, pathsToFollow);
        log.info("  Part 1: {}", countedTrees);
    }

    @Override
    public void part2() throws IOException {
        List<String> mapLines = readDataAsListForDay(3);
        List<Coordinate> pathsToFollow = List.of(new Coordinate(1, 1), new Coordinate(3, 1), new Coordinate(5, 1),
                new Coordinate(7, 1), new Coordinate(1, 2));
        long result = followSlope(mapLines, pathsToFollow);
        log.info("  Part 2: {}", result);
    }
}
