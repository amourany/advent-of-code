package fr.amou.advent.of.code.year2020.days.day17;

import fr.amou.advent.of.code.year2020.Day2020;

import java.io.IOException;

public class Day17 extends Day2020 {

    public Day17() {
        super(17);
    }

    public static void main(String[] args) throws IOException {
        new Day17().printParts();
    }

    public static long simulateAndCountActives(String initialState, int roundNumbers, Integer dimensions) {
        Universe knownUniverse = new Universe(initialState, dimensions);
        Integer currentRound = 0;

        while (currentRound < roundNumbers) {
            knownUniverse.expand();
            currentRound++;
        }

        return knownUniverse.countActiveCubes();
    }

    @Override
    public Object part1() throws IOException {
        String initialState = readData();
        return simulateAndCountActives(initialState, 6, 3);
    }

    @Override
    public Object part2() throws IOException {
        String initialState = readData();
        return simulateAndCountActives(initialState, 6, 4);
    }
}
