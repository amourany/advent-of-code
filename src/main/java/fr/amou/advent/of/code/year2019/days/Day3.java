package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.Day2019;
import lombok.Data;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day3 extends Day2019 {

    public Day3() {
        super(3);
    }

    public static void main(String[] args) throws IOException {
        new Day3().printParts();
    }

    public static Integer computeDistance(List<String> blueWire, List<String> redWire) {

        Set<String> blueWirePath = processWire(blueWire);
        Set<String> redWirePath = processWire(redWire);

        List<String> crossPaths = blueWirePath.stream()
                .filter(redWirePath::contains)
                .collect(Collectors.toList());

        List<Integer> distanceList = crossPaths.stream()
                .map(s -> {
                    String[] positionArray = s.split(":");
                    Integer x = Math.abs(Integer.parseInt(positionArray[0]));
                    Integer y = Math.abs(Integer.parseInt(positionArray[1]));
                    return x + y;
                })
                .collect(Collectors.toList());

        return Collections.min(distanceList);
    }

    public static Integer computeSteps(List<String> blueWire, List<String> redWire) {
        Set<String> blueWirePath = processWire(blueWire);
        Set<String> redWirePath = processWire(redWire);

        List<String> crossPaths = blueWirePath.stream()
                .filter(redWirePath::contains)
                .collect(Collectors.toList());
        List<Integer> stepsList = crossPaths.stream()
                .map(s -> {
                    Integer blueSteps = processSteps(blueWire, s);
                    Integer redSteps = processSteps(redWire, s);

                    return blueSteps + redSteps;
                })
                .collect(Collectors.toList());
        return Collections.min(stepsList);
    }

    private static Set<String> processWire(List<String> wire) {

        Set<String> wirePath = new HashSet<>();

        Point currentPoint = new Point(0, 0);

        wire.forEach(direction -> {

            Direction directionEnum = Direction.valueOf(direction.substring(0, 1));

            Integer steps = Integer.parseInt(direction.substring(1));

            for (int i = 0; i < steps; i++) {
                switch (directionEnum) {
                    case R:
                        currentPoint.setX(currentPoint.getX() + 1);
                        break;
                    case L:
                        currentPoint.setX(currentPoint.getX() - 1);
                        break;
                    case D:
                        currentPoint.setY(currentPoint.getY() - 1);
                        break;
                    case U:
                        currentPoint.setY(currentPoint.getY() + 1);
                        break;
                }

                wirePath.add(currentPoint.toString());
            }
        });

        return wirePath;
    }

    private static Integer processSteps(List<String> wire, String goal) {
        Integer stepsCounter = 0;

        Point currentPoint = new Point(0, 0);

        Boolean reachedGoal = false;

        for (String direction : wire) {
            Direction directionEnum = Direction.valueOf(direction.substring(0, 1));

            Integer steps = Integer.parseInt(direction.substring(1));

            if (!reachedGoal) {
                for (int i = 0; i < steps; i++) {
                    switch (directionEnum) {
                        case R:
                            currentPoint.setX(currentPoint.getX() + 1);
                            break;
                        case L:
                            currentPoint.setX(currentPoint.getX() - 1);
                            break;
                        case D:
                            currentPoint.setY(currentPoint.getY() - 1);
                            break;
                        case U:
                            currentPoint.setY(currentPoint.getY() + 1);
                            break;
                    }

                    if (!reachedGoal) {
                        stepsCounter++;
                    }

                    if (currentPoint.toString()
                            .equals(goal)) {
                        reachedGoal = true;
                    }
                }
            }
        }

        return stepsCounter;
    }

    @Override
    public Object part1() throws IOException {
        List<String> dataStringList = readDataAsList();
        List<List<String>> wires = dataStringList.stream()
                .map(s -> Arrays.asList(s.split(",")))
                .collect(Collectors.toList());

        return computeDistance(wires.get(0), wires.get(1));
    }

    @Override
    public Object part2() throws IOException {
        List<String> dataStringList = readDataAsList();
        List<List<String>> wires = dataStringList.stream()
                .map(s -> Arrays.asList(s.split(",")))
                .collect(Collectors.toList());

        return computeSteps(wires.get(0), wires.get(1));
    }

    public enum Direction {
        U,
        D,
        L,
        R
    }

    @Data
    public static class Point {

        private Integer x;
        private Integer y;

        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + ":" + y;
        }
    }
}
