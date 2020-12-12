package fr.amou.advent.of.code.year2020.days.day12;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;
import java.util.List;

import static fr.amou.advent.of.code.year2020.days.day12.Action.E;
import static fr.amou.advent.of.code.year2020.days.day12.Action.N;

public class Day12 extends Day2020 {

    public Day12() {
        super(12);
    }

    public static void main(String[] args) throws IOException {
        new Day12().printParts();
    }

    public static Integer computeManhattanDistance(Ship ship) {
        return Math.abs(ship.getShipPosition()
                .get(E)) + Math.abs(ship.getShipPosition()
                .get(N));
    }

    public static Ship followEvasivePath(List<String> instructions, InstructionRuleSet ruleSet) {
        Ship ship = new Ship();
        instructions.stream()
                .map(Day12::parseInstruction)
                .forEach(instruction -> ruleSet.resolveRule(ship, instruction));
        return ship;
    }

    private static Direction parseInstruction(String instruction) {
        return new Direction(instruction.substring(0, 1), instruction.substring(1));
    }

    @Override
    public Object part1() throws IOException {
        List<String> instructions = readDataAsList();
        Ship ship = followEvasivePath(instructions, new Part1RuleSet());
        return computeManhattanDistance(ship);
    }

    @Override
    public Object part2() throws IOException {
        List<String> instructions = readDataAsList();
        Ship ship = followEvasivePath(instructions, new Part2RuleSet());
        return computeManhattanDistance(ship);
    }
}
