package fr.amou.advent.of.code.days;

import fr.amou.advent.of.code.common.Day;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fr.amou.advent.of.code.utils.DataReader.readDataAsListForDay;

@Log4j2
public class Day3 implements Day {

    private static final String TREE_SYMBOL = "#";

    public static void main(String[] args) throws IOException {
        Day day = new Day3();
        day.part1();
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

    private static Integer countTrees(Map<Coordinate, String> regionMap) {

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
        int foundTrees = 0;

        while (currentYPos < regionHeight) {

            currentXPos = (currentXPos + 3) % (regionWidth + 1);
            currentYPos = (currentYPos + 1);

            Coordinate newCoordinate = new Coordinate(currentXPos, currentYPos);
            if (regionMap.containsKey(newCoordinate) && regionMap.get(newCoordinate)
                    .equals(TREE_SYMBOL)) {
                foundTrees++;
            }
        }

        return foundTrees;
    }

    public static Integer followSlopeCountingTree(List<String> mapLines) {
        Map<Coordinate, String> regionMap = buildMap(mapLines);
        return countTrees(regionMap);
    }

    @Override
    public void part1() throws IOException {
        List<String> mapLines = readDataAsListForDay(3);
        long countedTrees = followSlopeCountingTree(mapLines);
        log.info("  Part 1: {}", countedTrees);
    }

    @Override
    public void part2() throws IOException {

    }

    public static class Coordinate {

        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
